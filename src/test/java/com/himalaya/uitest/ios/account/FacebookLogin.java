package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLogin extends AbstractTestCase {

    @Test(description = "fb登录")
    public void testFacebookLogin() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //点击 FB 登录按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.FB_LOGIN_BTN())).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        try {
            //输入账号密码并登录
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.FB_ACCOUNT())).sendKeys(Utils.getProperties("FB_ACCOUNT"));
            iosDriver.findElement(accountPage.FB_PASSWORD()).click();
            iosDriver.findElement(accountPage.FB_PASSWORD()).sendKeys(Utils.getProperties("FB_PASSWORD"));
            iosDriver.findElement(accountPage.FB_LOGIN()).click();
        } catch (Exception e) {
        }

        //点击继续
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.FB_CONTINUE())).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //断言登录成功
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入 discover");
    }
}
