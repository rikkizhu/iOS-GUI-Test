package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MiniPlayer extends AbstractTestCase {
    Steps steps = new Steps();
    Utils utils = new Utils();

    @BeforeMethod
    public void setup() {
        //进入MyShow
        steps.enterMyShow(iosDriver);
        try {
            iosDriver.findElement(playerPage.CLOSE_BTN_IN_MINIBAR()).click();
        } catch (Exception e) {

        }
    }

    @Test(description = "minibar 的打开、唤起、关闭、播放、暂停、回退")
    public void testMiniPlayer() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击第一条声音开始播放
        iosDriver.findElement(albumPage.MY_SHOW_FIRST_EPISODE()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PLAYER_PROGRESS()));

        //下滑大播放页，打开 minibar
        int height = iosDriver.manage().window().getSize().height;
        utils.swipePageUpDown(iosDriver, height / 4, height * 3 / 4);
        //验证打开 minibar
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.IMAGE_BTN_IN_MINIBAR()));
        Assert.assertTrue(iosDriver.findElement(playerPage.IMAGE_BTN_IN_MINIBAR()).isDisplayed(), "验证打开minibar");

        //验证minibar处于播放状态
        int init_progress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        Thread.sleep(8 * 1000);
        int played_progress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        Assert.assertTrue(played_progress > init_progress, "验证播放中，有播放进度");

        //暂停播放
        iosDriver.findElement(playerPage.PAUSE_BTN_IN_MINIBAR()).click();
        Thread.sleep(3 * 1000);
        int paused_progress1 = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        Thread.sleep(8 * 1000);
        int paused_progress2 = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //断言暂停后播放进度没有增加
        Assert.assertTrue(paused_progress1 == paused_progress2, "验证暂停，无播放进度");

        //恢复播放，唤起大播放页
        iosDriver.findElement(playerPage.PLAY_BTN_IN_MINIBAR()).click();
        iosDriver.findElement(playerPage.IMAGE_BTN_IN_MINIBAR()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PRE_SEEK_PLAYER()));
        //断言成功唤起大播放页
        Assert.assertTrue(iosDriver.findElement(playerPage.PRE_SEEK_PLAYER()).isDisplayed(), "验证成功唤起大播放页");

        //返回minibar并点击回退按钮
        utils.swipePageUpDown(iosDriver, height / 4, height * 3 / 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.IMAGE_BTN_IN_MINIBAR()));
        int seek_progress1 = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        for (int i = 0; i < 4; i++) {
            iosDriver.findElement(playerPage.SEEK_BTN_IN_MINIBAR()).click();
        }
        Thread.sleep(1 * 1000);
        int seek_progress2 = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //断言进度已回退
        Assert.assertTrue(seek_progress1 > seek_progress2, "验证回退后，进度变小");

        //关闭minibar
        iosDriver.findElement(playerPage.CLOSE_BTN_IN_MINIBAR()).click();
        Assert.assertTrue(iosDriver.findElements(playerPage.IMAGE_BTN_IN_MINIBAR()).size() <= 0);
    }
}
