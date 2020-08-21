package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "{account}")
public class EmailSignUp extends AbstractTestCase {
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

    @Test(description = "邮箱注册测试")
    public void testEmail_SignUp() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        // 点击 "邮箱登录"按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT())).clear();
        iosDriver.findElement(accountPage.EMAIL_INPUT()).sendKeys(RandomStringUtils.randomAlphanumeric(6) + "@hi.com");

        //点击 continue 进入下一页
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.CONTINUE_BUTTON()));
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //输入密码
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.PASSWORD_INPUT()));
        iosDriver.findElement(accountPage.PASSWORD_INPUT()).sendKeys(Utils.getProperties("EMAIL_PASSWORD"));

        //点击 SignUp
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.SIGH_UP()));
        iosDriver.findElement(accountPage.SIGH_UP()).click();

        //限免礼包
        try{
            //跳过限免礼包
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 3);
            wait2.until(ExpectedConditions.presenceOfElementLocated(accountPage.SKIP_BTN_ON_FREE_LIMIT()));
            iosDriver.findElement(accountPage.SKIP_BTN_ON_FREE_LIMIT()).click();
        }catch (Exception e){
        }

        //新手引导
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
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入 discover");
    }

}
