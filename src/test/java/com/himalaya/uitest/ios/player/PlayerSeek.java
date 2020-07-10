package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlayerSeek extends AbstractTestCase {
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

    @Test(description = "大播放页 seek")
    public void testPlayerSeek() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击第三条声音进入大播放页
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.MY_SHOW_THIRD_EPISODE())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PLAYER_PROGRESS()));
        //暂停播放
        iosDriver.findElement(playerPage.PLAY_PAUSE_BTN()).click();

        //获取初始播放进度
        int initProgress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //向后 seek
        for (int i = 0; i < 4; i++) {
            iosDriver.findElement(playerPage.NEXT_SEEK_PLAYER()).click();
        }
        int nextProgress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //验证向后seek成功，progress 变大
        Assert.assertTrue(nextProgress > initProgress, "验证向后seek成功，progress 变大");

        //向前 seek
        for (int i = 0; i < 4; i++) {
            iosDriver.findElement(playerPage.PRE_SEEK_PLAYER()).click();
        }
        int preProgress = Integer.parseInt(iosDriver.findElement(playerPage.PLAYER_PROGRESS()).getAttribute("value").replace("%", ""));
        //验证向前seek成功，progress 变小
        Assert.assertTrue(nextProgress > preProgress, "验证向前seek成功，progress 变小");
    }
}
