package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiAlbumLoginSwitch extends AbstractTestCase {

    @Test(description = "多专辑账号登录及切换")
    public void testMultiAlbumLoginSwitch() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        // 点击 "邮箱登录"按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT()));
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
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //断言成功进入 discover
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_TAB_BTN()).isDisplayed(), "验证是否进入 discover");

        //进入 profile 页
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();

        //断言用户名子用户1： bdmy2
        Assert.assertTrue(iosDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='bdmy2']")).isDisplayed(), "断言断言用户名子用户1： bdmy2");

        //切换用户
        iosDriver.findElement(profilePage.Switch_Show_Btn()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("bdmy2子专辑1")));
        iosDriver.findElement(MobileBy.AccessibilityId("bdmy2子专辑1")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.SEARCH_BAR_DISCOVER_TAB()));

        //进入 profile 页
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();

        //断言用户名子用户2：bdmy2子专辑1
        Assert.assertTrue(iosDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='bdmy2子专辑1']")).isDisplayed(), "断言用户名子用户2：bdmy2子专辑1");
    }
}
