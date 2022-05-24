package com.xxxx.uitest.ios.cases.player;

import com.xxxx.uitest.ios.BaseTestCase;
import com.xxxx.uitest.ios.Steps;
import com.xxxx.uitest.ios.Utils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
由于大播放页存在过多只能用xpath定位的元素，会影响执行效率，偶尔还会出现xpath定位不到的问题
*/

public class SwitchEpisodeBySwipe extends BaseTestCase {
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

    @Test(description = "大播放页滑动切换上下首")
    public void testSwitchEpisodeBySwipe() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 60);

        //点击第三条声音开始播放
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.MY_SHOW_THIRD_EPISODE()));
        iosDriver.findElement(albumPage.MY_SHOW_THIRD_EPISODE()).click();

        //获取第三首声音名称
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.EPISODE_NAME_PLAYER())).isDisplayed();
        String EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //切换下一首
        int width = iosDriver.manage().window().getSize().width;
        utils.swipePageLeftRight(iosDriver, width * 3 / 4, width / 4);
        Thread.sleep(3000);

        //获取下一首的声音名称
        String NEXT_EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //验证声音名称不同，声音切换成功
        Assert.assertFalse("验证声音名称不同，声音切换成功", EPISODE_NAME.equals(NEXT_EPISODE_NAME));

        //滑动切换上一首
        utils.swipePageLeftRight(iosDriver, width / 4, width * 3 / 4);
        Thread.sleep(3000);

        //获取上一首的声音名称
        String EPISODE_NAME2 = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER())).getAttribute("value");

        //验证切换回上一首成功
        Assert.assertTrue("验证切换回上一首成功，声音名为第一首声音", EPISODE_NAME.equals(EPISODE_NAME2));
    }

}
