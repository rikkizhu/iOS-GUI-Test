package com.***REMOVED***.uitest.ios.album;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FollowUnfollowedAlbum extends AbstractTestCase {
    Steps steps = new Steps();
    Utils utils = new Utils();

    @Test
    public void testFollowAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        //邮箱登录
        steps.singUpByEmail(iosDriver);
        //进入专辑页
        steps.searchAlbum(iosDriver);

        //点击 follow 按钮
        iosDriver.findElement(albumPage.FOLLOW_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.SETTING_BTN_BEHIND_FOLLOWING()));

        //验证 follow 成功
        Assert.assertTrue(iosDriver.findElement(albumPage.FOLLOWING_BTN()).isDisplayed(), "验证 following 按钮存在");
        Assert.assertTrue(iosDriver.findElement(albumPage.SETTING_BTN_BEHIND_FOLLOWING()).isDisplayed(), "验证following右侧设置按钮存在");
        Assert.assertTrue(iosDriver.findElement(albumPage.LISTENERS_ALSO_FOLLOWED()).isDisplayed(), "验证 Listeners Also Followed 存在");

        //退出回到 search 页
        iosDriver.findElement(albumPage.BACKWARD_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN()));

        //点击 library tab
        iosDriver.findElement(libraryPage.Library_TAB_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.FOLLOWED_SHOWS_CELL()));

        //验证library页存在该专辑
        String ALBUM_NAME = iosDriver.findElement(libraryPage.FOLLOWED_SHOWS_NAME()).getAttribute("value");
        Assert.assertTrue(ALBUM_NAME.equals("买断专辑测试"), "验证library中存在关注的专辑");
    }

    @Test(dependsOnMethods = {"testFollowAlbum"})
    public void testUnFollowAlbum() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        //从 library 进入专辑页
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.FOLLOWED_SHOWS_CELL())).click();

        //点击取消 follow 按钮
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOWING_BTN())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FOLLOW_BTN()));

        //验证取消成功
        Assert.assertTrue(iosDriver.findElements(albumPage.SETTING_BTN_BEHIND_FOLLOWING()).size() <= 0, "验证设置按钮消失");
        Assert.assertTrue(iosDriver.findElement(albumPage.FOLLOW_BTN()).isDisplayed(), "验证 follow 按钮存在");

        //退出回到 search 页
        iosDriver.findElement(albumPage.BACKWARD_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN()));

        //验证library页不存在该专辑
        Assert.assertTrue(iosDriver.findElement(libraryPage.FOLLOW_HINTS_LIBRARY()).isDisplayed(), "验证关注专辑提示存在，表明没有关注专辑");
        Assert.assertTrue(iosDriver.findElement(libraryPage.ZERO_SHOW_COUNT()).isDisplayed(), "验证关注专辑计数为0");
    }
}
