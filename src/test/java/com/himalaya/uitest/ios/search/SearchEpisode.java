package com.***REMOVED***.uitest.ios.search;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchEpisode extends AbstractTestCase {
    @Test(description = "全局搜索声音")
    public void testSearchEpisode() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //进入search tab点击搜索框
        iosDriver.findElement(searchPage.SEARCH_TAB_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_BAR_SEARCH_TAB())).click();

        //输入搜索内容
        iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).sendKeys(Utils.getProperties("SEARCH_ALBUM"));
        List<IOSElement> SEARCH_BUTTONS = iosDriver.findElements(searchPage.KEYBOARD_SEARCH());
        SEARCH_BUTTONS.get(1).click();

        //选择声音tab
        iosDriver.findElement(searchPage.RESULT_EPISODES_TAB()).click();

        //验证搜索出专辑对应声音
        Thread.sleep(1000);
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_ALBUM_CELL()).isDisplayed(), "验证有声音搜索结果");
        Assert.assertTrue(iosDriver.findElements(MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("MY_SHOW_FIRST_EPISODE_NAME") + "'")).size() > 0,
                "验证搜索结果中有目标声音");
    }
}
