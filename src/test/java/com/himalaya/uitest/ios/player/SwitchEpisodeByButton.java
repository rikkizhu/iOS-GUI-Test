package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchEpisodeByButton extends AbstractTestCase {
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

    @Test(description = "大播放页按钮切换上下首")
    public void testSwitchEpisodeByBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击第一条声音开始播放
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.FIRST_EPISODE()));
        iosDriver.findElement(albumPage.FIRST_EPISODE()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_PREVIOUS_EPISODE_BTN()));

        //判断第一首歌曲上一首按钮置灰
        String isEnabled = iosDriver.findElement(playerPage.SWITCH_PREVIOUS_EPISODE_BTN()).getAttribute("enabled");
        Assert.assertEquals("验证上一首不可点击", "false", isEnabled);

        //获取第一首声音名称
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.EPISODE_NAME_PLAYER())).isDisplayed();
        String FIRST_EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //切换下一首
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_NEXT_EPISODE_BTN())).isDisplayed();
        iosDriver.findElement(playerPage.SWITCH_NEXT_EPISODE_BTN()).click();
        Thread.sleep(3000);

        //获取下一首的声音名称
        String NEXT_EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //验证声音名称不同，声音切换成功
        Assert.assertFalse("验证声音名称不同，声音切换成功", FIRST_EPISODE_NAME.equals(NEXT_EPISODE_NAME));
        //验证当前首声音，上一首按钮可以点击
        Assert.assertTrue(iosDriver.findElement(playerPage.SWITCH_PREVIOUS_EPISODE_BTN()).getAttribute("enabled").equals("true"));

        //点击上一首按钮
        iosDriver.findElement(playerPage.SWITCH_PREVIOUS_EPISODE_BTN()).click();
        Thread.sleep(3000);

        //获取上一首的声音名称
        String FIRST_EPISODE_NAME2 = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //验证切换回上一首成功
        Assert.assertTrue("验证切换回上一首成功，声音名为第一首声音", FIRST_EPISODE_NAME.equals(FIRST_EPISODE_NAME2));
    }
}
