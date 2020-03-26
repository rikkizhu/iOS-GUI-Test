package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchEpisodeBySwipe extends AbstractTestCase {
    Steps steps = new Steps();
    Utils utils = new Utils();

    @BeforeMethod
    public void setup() {
        // 邮箱登录
        steps.loginByEmail(iosDriver);

        //进入MyShow
        steps.enterMyShow(iosDriver);
    }

    @Test(description = "大播放页滑动切换上下首")
    public void testSwitchEpisodeBySwipe() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

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
        int width = iosDriver.manage().window().getSize().width;
        utils.swipePageLeftRight(iosDriver,width*3/4,width/4);

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
