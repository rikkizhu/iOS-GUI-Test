package com.***REMOVED***.uitest.ios;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Utils {

    IOSDriver iosDriver;

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

    public void swipePage(IOSDriver iosDriver, Integer int_height, Integer end_height) {
        TouchAction action = new TouchAction(iosDriver);
        action.longPress(PointOption.point(iosDriver.manage().window().getSize().width / 2, int_height))
                .waitAction(WaitOptions.waitOptions(Duration.ofNanos(15000)))
                .moveTo(PointOption.point(iosDriver.manage().window().getSize().width / 2, end_height))
                .release().perform();
    }
}
