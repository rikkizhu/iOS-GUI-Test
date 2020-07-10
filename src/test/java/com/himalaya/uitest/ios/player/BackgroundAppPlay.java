package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BackgroundAppPlay extends AbstractTestCase {
    Steps steps = new Steps();

    @BeforeMethod
    public void setup() {
        //进入MyShow
        steps.enterMyShow(iosDriver);
        try {
            iosDriver.findElement(playerPage.CLOSE_BTN_IN_MINIBAR()).click();
        } catch (Exception e) {
        }
    }

    @Test(description = "锁屏播放及app后置播放")
    public void testBackgroundAppPlay() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击第一条声音获取初始播放进度
        iosDriver.findElement(albumPage.MY_SHOW_FIRST_EPISODE()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PLAYER_PROGRESS()));

        //后置app10秒钟再打开
        iosDriver.runAppInBackground(Duration.ofSeconds(10));
        int initProgress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        Thread.sleep(3000);
        int activeAppProgress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));

        //后置app,仍处于播放状态,验证播放进度有增加
        Assert.assertTrue(activeAppProgress > initProgress, "验证app后置再前置，仍处于播放状态");
    }
}

