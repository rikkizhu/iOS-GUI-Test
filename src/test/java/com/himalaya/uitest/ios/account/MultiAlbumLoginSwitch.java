package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"account"})
public class MultiAlbumLoginSwitch extends AbstractTestCase {
    Steps steps = new Steps();

    @BeforeMethod
    public void setUp() {
        try {
            steps.logOut(iosDriver);
        } catch (Exception e) {
        }
    }

    @AfterMethod
    public void tearDown() {
        steps.logOut(iosDriver);
    }

    @Test(description = "多专辑账号登录及切换")
    public void testMultiAlbumLoginSwitch() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        // 点击 "邮箱登录"按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT()));
        iosDriver.findElement(accountPage.EMAIL_INPUT()).clear();
        iosDriver.findElement(accountPage.EMAIL_INPUT()).sendKeys(Utils.getProperties("MULTI_ALBUM_ACCOUNT"));

        //点击 continue 进入下一页
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.CONTINUE_BUTTON()));
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //输入密码
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.PASSWORD_INPUT()));
        iosDriver.findElement(accountPage.PASSWORD_INPUT()).sendKeys(Utils.getProperties("MULTI_ALBUM_PASSWORD"));

        //点击 Login
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.LOGIN_BTN()));
        iosDriver.findElement(accountPage.LOGIN_BTN()).click();

        //选择账户
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CHOOSE_MULTI_ALBUM_HINT()));
        iosDriver.findElement(accountPage.FIRST_MULTI_ALBUM_ACCOUNT()).click();

        //accept 弹窗
        try {
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 3);
            wait2.until(ExpectedConditions.alertIsPresent());
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {

        }

        //断言成功进入 discover
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入 discover");

        //进入 profile 页
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();

        //断言用户名子用户1正确
        Assert.assertTrue(iosDriver.findElement(MobileBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("Multi_Album_NAME1") + "'")).isDisplayed(), "断言断言用户名子用户1正确");

        //切换用户
        iosDriver.findElement(profilePage.Switch_Show_Btn()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(Utils.getProperties("Multi_Album_NAME2"))));
        iosDriver.findElement(MobileBy.AccessibilityId(Utils.getProperties("Multi_Album_NAME2"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));

        //进入 profile 页
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();

        //断言用户名子用户2正确
        Assert.assertTrue(iosDriver.findElement(MobileBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("Multi_Album_NAME2") + "'")).isDisplayed(), "断言断言用户名子用户2正确");
    }
}
