package com.xxxx.uitest.ios.cases.album;

import com.xxxx.uitest.ios.BaseTestCase;
import com.xxxx.uitest.ios.Steps;
import com.xxxx.uitest.ios.Utils;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FollowUnfollowedAlbum extends BaseTestCase {
    Steps steps = new Steps();

    @Test(description = "关注专辑")
    public void testFollowAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //进入专辑页
        steps.searchAlbum(iosDriver, Utils.getProperties("SEARCH_ALBUM"));

        //点击 follow 按钮
        if (iosDriver.findElements(albumPage.FOLLOWING_BTN()).size() > 0) {
            iosDriver.findElement(albumPage.FOLLOWING_BTN()).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOW_BTN()));
        }
        iosDriver.findElement(albumPage.FOLLOW_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOWING_BTN()));

        //验证 follow 成功
        Assert.assertTrue(iosDriver.findElement(albumPage.FOLLOWING_BTN()).isDisplayed(), "验证 following 按钮存在");
        Assert.assertTrue(iosDriver.findElement(albumPage.SETTING_BTN_BEHIND_FOLLOWING()).isDisplayed(), "验证following右侧设置按钮存在");
        Assert.assertTrue(iosDriver.findElement(albumPage.LISTENERS_ALSO_FOLLOWED()).isDisplayed(), "验证 Listeners Also Followed 存在");

        //退出回到 search 页
        List<IOSElement> BACKWARD_BTN_TYPE = iosDriver.findElements(albumPage.BACKWARD_BTN_TYPE());
        BACKWARD_BTN_TYPE.get(0).click();

        //进入library页
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN())).click();

        //由view as shows切换为view as episodes
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.VIEW_AS_SHOWS_BTN()));
        iosDriver.findElement(libraryPage.VIEW_AS_SHOWS_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.View_As_Episodes())).click();

        //验证切换为 episodes 列表，有内容
        Assert.assertTrue(iosDriver.findElements(libraryPage.FOLLOWED_CELL()).size() > 0, "验证声音维度关注列表有内容");

        //由view as episodes切换为view as shows
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.View_As_Episodes())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.VIEW_AS_SHOWS_BTN())).click();

        //验证library页存在该专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.FOLLOWED_CELL()));
        iosDriver.findElement(libraryPage.FOLLOWED_CELL()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOWING_BTN()));
        Assert.assertTrue(iosDriver.findElement(albumPage.ALBUM_TITLE_ALBUM_PAGE()).isDisplayed(), "验证该专辑被follow");
    }


    @Test(dependsOnMethods = {"testFollowAlbum"}, description = "取消关注专辑")
    public void testUnFollowAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击取消 follow 按钮
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOWING_BTN())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOW_BTN()));

        //验证取消成功
        Assert.assertTrue(iosDriver.findElements(albumPage.SETTING_BTN_BEHIND_FOLLOWING()).size() <= 0, "验证设置按钮消失");
        Assert.assertTrue(iosDriver.findElement(albumPage.FOLLOW_BTN()).isDisplayed(), "验证 follow 按钮存在");

        //退出回到 library 页
        List<IOSElement> BACKWARD_BTN_TYPE = iosDriver.findElements(albumPage.BACKWARD_BTN_TYPE());
        BACKWARD_BTN_TYPE.get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN()));

        //验证library页不存在该专辑
        Assert.assertTrue(iosDriver.findElement(libraryPage.FOLLOW_HINTS_LIBRARY()).isDisplayed(), "验证关注专辑提示存在，表明没有关注专辑");
    }
}
