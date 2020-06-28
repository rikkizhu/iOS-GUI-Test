package com.***REMOVED***.uitest.ios.search;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchEpisodeInAlbum extends AbstractTestCase {
    Steps steps = new Steps();

    @BeforeMethod
    public void setUp() {
        steps.searchAlbum(iosDriver,Utils.getProperties("SEARCH_ALBUM"));
    }

    @Test(description = "专辑页搜索")
    public void testSearchEpisodeInAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //点击右上角detail的搜索按钮
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.Detail_More_ALBUM_PAGE())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.SEARCH_EPISODES_IN_SHOW_BTN())).click();

        //输入搜索内容，点击搜索
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.SEARCH_FIELD_IN_SHOW())).sendKeys(Utils.getProperties("MY_SHOW_THIRD_EPISODE_NAME"));
        wait.until(ExpectedConditions.presenceOfElementLocated((searchPage.KEYBOARD_SEARCH()))).click();

        //验证搜索出专辑对应声音
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_EPISODE_CELL_IN_ALBUM()).isDisplayed(), "验证有声音搜索结果");
        Assert.assertTrue(iosDriver.findElements(MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("MY_SHOW_THIRD_EPISODE_NAME") + "'")).size() > 0,
                "验证搜索结果中有目标声音");
    }
}
