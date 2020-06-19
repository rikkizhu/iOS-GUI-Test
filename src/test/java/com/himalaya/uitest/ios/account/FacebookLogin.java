package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"account"})
public class FacebookLogin extends AbstractTestCase {
    Steps steps = new Steps();

    @BeforeMethod
    public void setUp(){
        try{
            steps.logOut(iosDriver);
        }catch (Exception e){
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
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.FB_OPEN())).click();

        //点击continue
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CONTINUE_BUTTON())).click();

        //accept 弹窗
        try {
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {
        }

        //断言登录成功
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入 discover");
    }
}
