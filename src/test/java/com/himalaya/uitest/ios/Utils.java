package com.***REMOVED***.uitest.ios;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;

public class Utils {

    IOSDriver iosDriver;

    public IOSDriver launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4.5");
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
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/***REMOVED***/Downloads/***REMOVED*** app/2.4.05/***REMOVED***.app");

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

    public void swipePageUpDown(IOSDriver iosDriver, Integer init_height, Integer end_height) {
        TouchAction action = new TouchAction(iosDriver);
        action.longPress(PointOption.point(iosDriver.manage().window().getSize().width / 2, init_height))
                .waitAction(WaitOptions.waitOptions(Duration.ofNanos(15000)))
                .moveTo(PointOption.point(iosDriver.manage().window().getSize().width / 2, end_height))
                .release().perform();
    }

    public void swipePageLeftRight(IOSDriver iosDriver, Integer init_width, Integer end_width) {
        TouchAction action = new TouchAction(iosDriver);
        action.longPress(PointOption.point(init_width, iosDriver.manage().window().getSize().height / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofNanos(15000)))
                .moveTo(PointOption.point(end_width, iosDriver.manage().window().getSize().height / 2))
                .release().perform();
    }

    public static String getProperties(String key) {
        FileInputStream fileInputStream = null;
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream(new File(Utils.class.getResource("/TestData.properties").getPath()));
            prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
            return prop.getProperty(key);
        } catch (IOException e) {
            throw new IllegalStateException("读取配置文件失败");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new IllegalStateException("读取配置文件时关闭文件失败");
                }
            }
        }
    }

}
