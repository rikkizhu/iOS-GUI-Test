package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"account"})
public class TouristLogin_HalfScreenEmailLogin_LogOut extends AbstractTestCase {
    Utils utils = new Utils();

    @Test(description = "游客登录")
    public void testTouristLogin() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击游客登录按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.TOURIST_LOGIN_BTN()));
        iosDriver.findElement(accountPage.TOURIST_LOGIN_BTN()).click();

        try {
            //跳过感兴趣的分类选择
            wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CATEGORY_TITLE_ON_GUIDE()));
            iosDriver.findElement(accountPage.SKIP_BTN_ON_GUIDE()).click();

            //跳过专辑建议选择
            wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.SHOW_SUGGESTIONS_TITLE_ON_GUIDE()));
            iosDriver.findElement(accountPage.SKIP_BTN_ON_GUIDE()).click();
        } catch (Exception e) {
        }

        //accept 弹窗
        try {
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 3);
            wait2.until(ExpectedConditions.alertIsPresent());
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {

        }

        //断言测试成功
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入discover");
    }

    @Test(description = "邮箱半屏登录", dependsOnMethods = {"testTouristLogin"})
    public void testHalfScreenEmailLogin() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);
        //进入 profile，点击登录
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.HALF_SCREEN_SIGNIN())).click();

        // 点击 "邮箱登录"按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT())).clear();
        iosDriver.findElement(accountPage.EMAIL_INPUT()).sendKeys(Utils.getProperties("EMAIL_ACCOUNT"));

        //点击 continue 进入下一页
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.CONTINUE_BUTTON()));
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //输入密码
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.PASSWORD_INPUT()));
        iosDriver.findElement(accountPage.PASSWORD_INPUT()).sendKeys(Utils.getProperties("EMAIL_PASSWORD"));

        //点击 Login
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.LOGIN_BTN()));
        iosDriver.findElement(accountPage.LOGIN_BTN()).click();

        //accept 弹窗
        try {
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {

        }

        //断言测试成功
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN()));
        Assert.assertTrue(iosDriver.findElement(profilePage.PROFILE_BTN()).isDisplayed(), "验证是否进入 profile");
    }

    @Test(description = "退出登录", dependsOnMethods = {"testHalfScreenEmailLogin"})
    public void testSignOut() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 20);

        //点击 Settings
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN())).click();
        int height = iosDriver.manage().window().getSize().height;
        utils.swipePageUpDown(iosDriver, height * 3 / 4, height / 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Setting_Btn())).click();

        //点击退出
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.LogOut_Btn())).click();

        //确认退出
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Log_Out_Alert())).click();

        //确认回到登录页
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
    }
}
