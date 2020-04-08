package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlayCount extends AbstractTestCase {
    Utils utils = new Utils();
    Steps steps = new Steps();

    @BeforeMethod
    public void setup() {
        // 邮箱登录
        steps.loginByEmail(iosDriver);

        //搜索专辑
        steps.searchAlbum(iosDriver);
    }

    @Test(description = "播放计数")
    public void testPlayCount() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        //记录一开始的播放个数
        String before_play = wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.PLAY_COUNT()))
                .getAttribute("value").replace(" Plays", "");
        Integer before_play_count = Integer.parseInt(before_play);

        //点击第一条声音开始播放
        iosDriver.findElement(albumPage.FIRST_EPISODE()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PLAYER_PROGRESS()));

        //下滑大播放页，打开 minibar
        int height = iosDriver.manage().window().getSize().height;
        utils.swipePageUpDown(iosDriver, height / 4, height * 3 / 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.IMAGE_BTN_IN_MINIBAR()));

        //关闭minibar
        iosDriver.findElement(playerPage.CLOSE_BTN_IN_MINIBAR()).click();

        //退出回到 search 页
        iosDriver.findElement(albumPage.BACKWARD_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN()));

        //点击进入第一个
        iosDriver.findElement(searchPage.FIRST_ALBUM_SEARCHED()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.JOIN_MEMBERSHIP()));

        String after_play = wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.PLAY_COUNT()))
                .getAttribute("value").replace(" Plays", "");
        Integer after_play_count = Integer.parseInt(after_play);

        //验证播放计数+1
        Assert.assertTrue(after_play_count.equals(before_play_count + 1), "验证播放计数是否加1");
    }
}
