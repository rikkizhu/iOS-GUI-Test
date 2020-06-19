package com.***REMOVED***.uitest.ios.search;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecentSearchesAndClearText extends AbstractTestCase {

    @Test(description = "搜索历史和清空搜索内容测试")
    public void testRecentSearchesAndClearText() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //进入搜搜页，点击搜索框
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_TAB_BTN())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_BAR_SEARCH_TAB())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.CANCEL_SEARCH_BTN())).isDisplayed();

        //输入搜索内容
        iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).sendKeys(Utils.getProperties("SEARCH_ALBUM"));
        iosDriver.findElement(searchPage.KEYBOARD_SEARCH()).click();

        //验证输入框中显示搜索内容
        Assert.assertTrue(iosDriver.findElement(searchPage.SEARCH_CONTENT_SEARCH_INPUT()).getAttribute("value").equals(Utils.getProperties("SEARCH_ALBUM")),
                "验证输入框中显示搜索内容");

        //点击清空 btn
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.CLEAR_TEXT_BTN()));
        iosDriver.findElement(searchPage.CLEAR_TEXT_BTN()).click();

        //验证数据被清空，显示默认提示
        Assert.assertTrue(iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).isDisplayed(), "验证数据被清空，显示默认提示");

        //验证存在Recent Searches
        Assert.assertTrue(iosDriver.findElement(searchPage.RECENT_SEARCH_TITLE()).isDisplayed(), "验证显示搜索历史");

        //验证搜索过文字存在
        Assert.assertTrue(iosDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + Utils.getProperties("SEARCH_ALBUM") + "']")).isDisplayed(),
                "验证搜索过的文字存在");
    }
}
