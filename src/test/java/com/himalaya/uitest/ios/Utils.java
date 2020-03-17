package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.AccountPage;
import com.***REMOVED***.uitest.ios.elements.DiscoverPage;
import com.***REMOVED***.uitest.ios.elements.ProfilePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Utils {

    IOSDriver iosDriver;

    AccountPage accountPage = new AccountPage();
    DiscoverPage discoverPage = new DiscoverPage();
    ProfilePage profilePage = new ProfilePage();

    public static String EMAIL_ACCOUNT = "***REMOVED***";
    public static String EMAIL_PASSWORD = "***REMOVED***";

    public IOSDriver lauchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID, "6027272dcff3571a8c89ad0b5dcb200db6ac98ff");
        capabilities.setCapability("bundleId", "com.***REMOVED***");

        iosDriver = new IOSDriver(new URL("HTTP://127.0.0.1:4723/wd/hub"), capabilities);
        return iosDriver;
    }

    public IOSDriver resetLaunchSimulator() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //启动模拟器配置
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/***REMOVED***/Downloads/***REMOVED***.app");

        return new IOSDriver(new URL("HTTP://127.0.0.1:4723/wd/hub"), capabilities);
    }


    public IOSDriver noResetLaunchSimulator() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //启动模拟器配置
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/***REMOVED***/Downloads/***REMOVED***.app");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        return new IOSDriver(new URL("HTTP://127.0.0.1:4723/wd/hub"), capabilities);
    }

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

    public void swipePage(IOSDriver iosDriver, Integer int_height, Integer end_height) {
        TouchAction action = new TouchAction(iosDriver);
        action.longPress(PointOption.point(iosDriver.manage().window().getSize().width / 2, int_height))
                .waitAction(WaitOptions.waitOptions(Duration.ofNanos(15000)))
                .moveTo(PointOption.point(iosDriver.manage().window().getSize().width / 2, end_height))
                .release().perform();
    }
}
