package com.***REMOVED***.uitest.ios.cases.player;

import com.***REMOVED***.uitest.ios.BaseTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PlayCount extends BaseTestCase {
    Utils utils = new Utils();
    Steps steps = new Steps();

    @BeforeMethod
    public void setup() {
        //搜索专辑
        steps.enterMyShow(iosDriver);
        try {
            iosDriver.findElement(playerPage.CLOSE_BTN_IN_MINIBAR()).click();
        } catch (Exception e) {

        }
    }

    @Test(description = "播放计数")
    public void testPlayCount() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //记录一开始的播放个数
        String before_play = wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.PLAY_COUNT()))
                .getAttribute("value").replace(" Plays", "");
        Integer before_play_count = Integer.parseInt(before_play);

        //点击第一条声音开始播放
        iosDriver.findElement(albumPage.MY_SHOW_FIRST_EPISODE()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.PLAYER_PROGRESS()));

        //下滑大播放页，打开 minibar
        int height = iosDriver.manage().window().getSize().height;
        utils.swipePageUpDown(iosDriver, height / 4, height * 3 / 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.IMAGE_BTN_IN_MINIBAR()));

        //关闭minibar
        iosDriver.findElement(playerPage.CLOSE_BTN_IN_MINIBAR()).click();

        //退出回到 profile 页
        List<IOSElement> BACKWARD_BTN_TYPE = iosDriver.findElements(albumPage.BACKWARD_BTN_TYPE());
        BACKWARD_BTN_TYPE.get(0).click();

        //点击进入专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.MYSHOW_BTN()));
        iosDriver.findElement(profilePage.MYSHOW_BTN()).click();

        String after_play = wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.PLAY_COUNT()))
                .getAttribute("value").replace(" Plays", "");
        Integer after_play_count = Integer.parseInt(after_play);

        //验证播放计数+1
        Assert.assertTrue(after_play_count.equals(before_play_count + 1), "验证播放计数是否加1");
    }
}
