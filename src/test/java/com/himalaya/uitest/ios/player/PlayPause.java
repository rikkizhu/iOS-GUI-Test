package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlayPause extends AbstractTestCase {
    Utils utils = new Utils();
    Steps steps = new Steps();

    @BeforeMethod
    public void setup() {
        // 邮箱登录
        steps.loginByEmail(iosDriver);

        //进入MyShow
        steps.enterMyShow(iosDriver);
    }

    @Test(description = "播放和暂停")
    public void testPlayPause() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);
        //点击第一条声音开始播放
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FIRST_EPISODE()));
        iosDriver.findElement(albumPage.FIRST_EPISODE()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PLAYER_PROGRESS()));

        //获取一开始的播放进度
        int init_progress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //等待10s
        Thread.sleep(10 * 1000);
        //获取播放10s后的播放进度
        int played_progress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));

        //断言播放进度有增加
        Assert.assertTrue(played_progress > init_progress, "验证播放中播放进度有增加");

        //暂停播放
        iosDriver.findElement(playerPage.PLAY_PAUSE_BTN()).click();
        //有操作延迟，需要再取一次值
        Thread.sleep(3 * 1000);
        int paused_progress1 = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //等待10s
        Thread.sleep(10 * 1000);
        //获取播放10s后的播放进度
        int paused_progress2 = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));

        //断言播放进度没有增加
        Assert.assertTrue(paused_progress1 == paused_progress2, "验证暂停后播放进度没有增加");

    }

}
