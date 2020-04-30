package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TouristLogin extends AbstractTestCase {
    @Test(description = "游客登录")
    public void testTouristLogin() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //点击游客登录按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.TOURIST_LOGIN_BTN()));
        iosDriver.findElement(accountPage.TOURIST_LOGIN_BTN()).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //断言测试成功
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入discover");
    }
}
