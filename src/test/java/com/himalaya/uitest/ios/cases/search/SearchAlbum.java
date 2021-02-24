package com.***REMOVED***.uitest.ios.cases.search;

import com.***REMOVED***.uitest.ios.BaseTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchAlbum extends BaseTestCase {

    @Test(description = "全局搜索专辑")
    public void testSearchAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //进入search tab点击搜索框
        iosDriver.findElement(searchPage.SEARCH_TAB_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_BAR_SEARCH_TAB()));
        iosDriver.findElement(searchPage.SEARCH_BAR_SEARCH_TAB()).click();

        //输入搜索内容
        iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).sendKeys(Utils.getProperties("SEARCH_ALBUM"));
        List<IOSElement> SEARCH_BUTTONS = iosDriver.findElements(searchPage.KEYBOARD_SEARCH());
        SEARCH_BUTTONS.get(1).click();

        //验证有返回搜索结果选择框
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.RESULT_SHOW_TAB())).isDisplayed();
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_EPISODES_TAB()).isDisplayed(), "出现声音搜索结果栏");
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_PLAYLISTS_TAB()).isDisplayed(), "出现播单搜索结果栏");

        //验证搜索出专辑
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_ALBUM_CELL()).isDisplayed(), "验证有专辑搜索结果");
        Assert.assertTrue(iosDriver.findElements(MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("SEARCH_ALBUM") + "'")).size() > 0,
                "验证搜索结果中有目标专辑");
    }

}
