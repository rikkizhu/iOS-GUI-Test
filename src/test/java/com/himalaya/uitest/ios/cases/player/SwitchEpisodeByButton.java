package com.xxxx.uitest.ios.cases.player;

import com.xxxx.uitest.ios.BaseTestCase;
import com.xxxx.uitest.ios.Steps;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
由于大播放页存在过多只能用xpath定位的元素，会影响执行效率，偶尔还会出现xpath定位不到的问题
*/
public class SwitchEpisodeByButton extends BaseTestCase {
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
        WebDriverWait wait = new WebDriverWait(iosDriver, 120);

        //点击第一条声音开始播放
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.MY_SHOW_FIRST_EPISODE()));
        iosDriver.findElement(albumPage.MY_SHOW_FIRST_EPISODE()).click();

        //判断第一首歌曲上一首按钮置灰
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_PRE_EPISODE_BTN()));
        String isEnabled = iosDriver.findElement(playerPage.SWITCH_PRE_EPISODE_BTN()).getAttribute("enabled");
        Assert.assertEquals("验证上一首不可点击", "false", isEnabled);

        //获取第一首声音名称
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.EPISODE_NAME_PLAYER()));
        String FIRST_EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //切换下一首
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_NEXT_EPISODE_BTN()));
        iosDriver.findElement(playerPage.SWITCH_NEXT_EPISODE_BTN()).click();
        Thread.sleep(3000);

        //获取下一首的声音名称
        String NEXT_EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //验证声音名称不同，声音切换成功
        Assert.assertFalse("验证声音名称不同，声音切换成功", FIRST_EPISODE_NAME.equals(NEXT_EPISODE_NAME));

        //验证当前首声音，上一首按钮可以点击
        Assert.assertTrue(iosDriver.findElement(playerPage.SWITCH_PRE_EPISODE_BTN()).getAttribute("enabled").equals("true"));

        //点击上一首按钮
        iosDriver.findElement(playerPage.SWITCH_PRE_EPISODE_BTN()).click();
        Thread.sleep(3000);

        //获取上一首的声音名称
        String FIRST_EPISODE_NAME2 = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //验证切换回上一首成功
        Assert.assertTrue("验证切换回上一首成功，声音名为第一首声音", FIRST_EPISODE_NAME.equals(FIRST_EPISODE_NAME2));
    }
}
