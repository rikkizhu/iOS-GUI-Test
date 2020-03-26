package com.***REMOVED***.uitest.ios.search;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchAlbum extends AbstractTestCase {
    Steps steps = new Steps();

    @BeforeMethod
    public void setup() {
        steps.loginBySkip(iosDriver);
    }

    @Test(description = "搜索专辑")
    public void testSearchAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        //点击discover上方搜索按钮，查看是否进入搜索页
        iosDriver.findElement(discoverPage.SEARCH_BAR_DISCOVER_TAB()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.CANCEL_SEARCH_BTN())).isDisplayed();

        //点击cancel按钮，返回discover
        iosDriver.findElement(searchPage.CANCEL_SEARCH_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_TAB_BTN()));

        //进入search tab点击搜索框
        iosDriver.findElement(searchPage.SEARCH_TAB_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_BAR_SEARCH_TAB()));
        iosDriver.findElement(searchPage.SEARCH_BAR_SEARCH_TAB()).click();

        //输入搜索内容
        iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).sendKeys("testiosgui");
        iosDriver.findElement(searchPage.KEYBOARD_SEARCH()).click();

        //验证有返回搜索结果选择框
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.RESULT_SHOW_TAB())).isDisplayed();
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_EPISODES_TAB()).isDisplayed(), "出现声音搜索结果栏");
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_PLAYLISTS_TAB()).isDisplayed(), "出现播单搜索结果栏");

        //验证搜索出专辑
        Assert.assertTrue(iosDriver.findElement(searchPage.RESULT_ALBUM_CELL()).isDisplayed(), "验证有专辑搜索结果");
        Assert.assertTrue(iosDriver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='testiosgui']")).size() > 0,
                "验证搜索结果中有目标专辑 testiosgui");
    }


}
