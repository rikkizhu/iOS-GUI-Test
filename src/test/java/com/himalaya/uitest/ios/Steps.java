package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.AccountPage;
import com.***REMOVED***.uitest.ios.elements.DiscoverPage;
import com.***REMOVED***.uitest.ios.elements.ProfilePage;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {
    AccountPage accountPage = new AccountPage();
    DiscoverPage discoverPage = new DiscoverPage();
    ProfilePage profilePage = new ProfilePage();
    public static String EMAIL_ACCOUNT = "***REMOVED***";
    public static String EMAIL_PASSWORD = "***REMOVED***";

    public void loginByEmail(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        // 点击 "邮箱登录"按钮
        new WebDriverWait(iosDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT()));
        iosDriver.findElement(accountPage.EMAIL_INPUT()).sendKeys(EMAIL_ACCOUNT);

        //点击 continue 进入下一页
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.CONTINUE_BUTTON()));
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //输入密码
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.PASSWORD_INPUT()));
        iosDriver.findElement(accountPage.PASSWORD_INPUT()).sendKeys(EMAIL_PASSWORD);

        //点击 Login
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.LOGIN_BTN()));
        iosDriver.findElement(accountPage.LOGIN_BTN()).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.TRENDING_BTN()));
    }

    public void enterMyShow(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        //进入profile
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN()));
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();

        //进入my show
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.MYSHOW_BTN()));
        iosDriver.findElement(profilePage.MYSHOW_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.RECORD_BTN_IN_MYSHOW()));
    }
}
