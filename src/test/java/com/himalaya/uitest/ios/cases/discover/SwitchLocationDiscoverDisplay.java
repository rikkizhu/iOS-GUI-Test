package com.xxxx.uitest.ios.cases.discover;

import com.xxxx.uitest.ios.BaseTestCase;
import com.xxxx.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SwitchLocationDiscoverDisplay extends BaseTestCase {

    Utils utils = new Utils();

    @AfterMethod
    public void tearDown() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //切换国家到大陆
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Setting_Btn())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.LOCATION_BUTTON())).click();
        utils.swipeUpToElement(iosDriver, profilePage.LOCATION_CHINAMAINLAND());
        iosDriver.findElement(profilePage.LOCATION_CHINAMAINLAND()).click();
        iosDriver.findElement(profilePage.LOCATION_BACK_BTN()).click();
    }

    @Test(description = "切换location，discover展示")
    public void testSwitchLocationDiscoverDisplay() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //获取切换前的国家discover第一个tab名称
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_FIRST_TAB()));
        String tabNme = iosDriver.findElement(discoverPage.DISCOVER_FIRST_TAB()).getAttribute("name");

        //切换国家到美国
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Setting_Btn())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.LOCATION_BUTTON())).click();
        utils.swipeDownToElement(iosDriver, profilePage.LOCATION_USA());
        iosDriver.findElement(profilePage.LOCATION_USA()).click();

        //返回到 discover
        iosDriver.findElement(profilePage.LOCATION_BACK_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.SETTING_BACK_BTN())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN())).click();

        //获取切换后discover第一个tab名称
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_FIRST_TAB()));
        String tabNme2 = iosDriver.findElement(discoverPage.DISCOVER_FIRST_TAB()).getAttribute("name");

        Assert.assertFalse(tabNme.equals(tabNme2), "验证切换国家后,discover 切换");
    }
}
