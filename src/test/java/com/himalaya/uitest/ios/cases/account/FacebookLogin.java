package com.xxxx.uitest.ios.cases.account;

import com.xxxx.uitest.ios.BaseTestCase;
import com.xxxx.uitest.ios.Steps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"account"})
public class FacebookLogin extends BaseTestCase {
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

    @Test(description = "fb登录")
    public void testFacebookLogin() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 60);

        //点击 FB 登录按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.FB_LOGIN_BTN())).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //点击open
        try {
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 5);
            wait2.until(ExpectedConditions.presenceOfElementLocated(accountPage.FB_OPEN())).click();
        } catch (Exception e) {
        }

        //点击continue
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CONTINUE_BUTTON())).click();

        //accept 弹窗
        try {
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 3);
            wait2.until(ExpectedConditions.alertIsPresent());
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {
        }

        //断言登录成功
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入 discover");
    }
}
