package com.xxxx.uitest.ios.cases.player;

import com.xxxx.uitest.ios.BaseTestCase;
import com.xxxx.uitest.ios.Steps;
import com.xxxx.uitest.ios.Utils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayQueen extends BaseTestCase {
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

    @AfterMethod
    public void tearDown() {
        //下滑大播放页，打开 minibar
        int height = iosDriver.manage().window().getSize().height;
        utils.swipePageUpDown(iosDriver, height / 4, height * 3 / 4);
        //关闭minibar
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.CLOSE_BTN_IN_MINIBAR())).click();
        //退出专辑页
        List<IOSElement> BACKWARD_BTN_TYPE = iosDriver.findElements(albumPage.BACKWARD_BTN_TYPE());
        BACKWARD_BTN_TYPE.get(0).click();
    }


    @Test(description = "播放队列中切换播放声音")
    public void testSwitchEpisodePlayQueen() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 120);

        //点击第一条声音开始播放
        wait.until(ExpectedConditions.elementToBeClickable(albumPage.MY_SHOW_FIRST_EPISODE())).click();

        //打开播放队列
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.QUEUE_BTN())).click();

        //播放队列中切换播放第3条声音
        wait.until(ExpectedConditions.elementToBeClickable(albumPage.MY_SHOW_THIRD_EPISODE())).click();

        //退出回到大播放页
        iosDriver.findElement(playerPage.QUEEN_BACK_BTN()).click();

        //验证当前声音名称，确认切换成功
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.EPISODE_NAME_PLAYER()));
        String THIRD_EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER()))
                .getAttribute("value").replace(" ", "");
        Assert.assertTrue("验证当前声音名称，确认切换成功", THIRD_EPISODE_NAME.equals(Utils.getProperties("MY_SHOW_THIRD_EPISODE_NAME")));

    }


    @Test(description = "反转播放队列")
    public void testReversePlayQueen() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 120);

        //点击第一条声音开始播放
        wait.until(ExpectedConditions.elementToBeClickable(albumPage.MY_SHOW_FIRST_EPISODE())).click();

        //打开播放队列
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.QUEUE_BTN())).click();

        //点击倒序按钮
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.REVERSE_QUEEN())).click();

        //退出回到大播放页
        iosDriver.findElement(playerPage.QUEEN_BACK_BTN()).click();

        //验证该声音下一首按钮置灰
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_NEXT_EPISODE_BTN()));
        String isNextEnabled = iosDriver.findElement(playerPage.SWITCH_NEXT_EPISODE_BTN()).getAttribute("enabled");
        Assert.assertEquals("验证下一首不可点击", "false", isNextEnabled);

        //再次倒序播放队列
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.QUEUE_BTN())).click();
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.REVERSE_QUEEN())).click();
        iosDriver.findElement(playerPage.QUEEN_BACK_BTN()).click();

        //验证该声音上一首按钮置灰
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_PRE_EPISODE_BTN()));
        String isPreEnabled = iosDriver.findElement(playerPage.SWITCH_PRE_EPISODE_BTN()).getAttribute("enabled");
        Assert.assertEquals("验证上一首不可点击", "false", isPreEnabled);
    }


    @Test(description = "播放队列手动排序")
    public void testManualSortPlayQueen() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(iosDriver, 120);

        //点击第一条声音开始播放
        wait.until(ExpectedConditions.elementToBeClickable(albumPage.MY_SHOW_FIRST_EPISODE())).click();

        //打开播放队列
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.QUEUE_BTN())).click();

        //移动第一条声音到最后
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SORT_BTN_LIST_PLAY_QUEEN()));
        WebElement FIRST_EPISODE = (WebElement) iosDriver.findElements(playerPage.SORT_BTN_LIST_PLAY_QUEEN()).get(0);


        //将第一个声音移动到最后
        TouchAction action = new TouchAction(iosDriver);
        JavascriptExecutor js = (JavascriptExecutor) iosDriver;
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 1.0);
        params.put("fromX", 0);
        params.put("fromY", 0);
        params.put("toX", 0);
        params.put("toY", 1000);
        params.put("element", ((RemoteWebElement) FIRST_EPISODE).getId());
        js.executeScript("mobile: dragFromToForDuration", params);

        //验证播放队列顺序
        List episodeQueen = iosDriver.findElements(playerPage.EPISODE_LIST_PLAY_QUEEN());
        WebElement newFirstEpisode = (WebElement) episodeQueen.get(0);
        WebElement newLastEpisode = (WebElement) episodeQueen.get(episodeQueen.size() - 1);
        String newFirstEpisodeName = newFirstEpisode.getAttribute("value");
        String newLastEpisodeName = newLastEpisode.getAttribute("value");

        Assert.assertTrue("播放队列中的第1首声音已改为原来的第2首",
                newFirstEpisodeName.equals(Utils.getProperties("MY_SHOW_SECOND_EPISODE_NAME")));
        Assert.assertTrue("播放队列中的最后一首声音已改为原来的第1首",
                newLastEpisodeName.equals(Utils.getProperties("MY_SHOW_FIRST_EPISODE_NAME")));

        //退出回到大播放页
        iosDriver.findElement(playerPage.QUEEN_BACK_BTN()).click();

        //验证该声音下一首按钮置灰
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.SWITCH_NEXT_EPISODE_BTN()));
        String isNextEnabled = iosDriver.findElement(playerPage.SWITCH_NEXT_EPISODE_BTN()).getAttribute("enabled");
        Assert.assertEquals("验证下一首不可点击", "false", isNextEnabled);
    }

    @Test(description = "播放队列移除声音")
    public void testRemoveEpisodeFromPlayQueen() {
        WebDriverWait wait = new WebDriverWait(iosDriver, 120);

        //点击第一条声音开始播放
        wait.until(ExpectedConditions.elementToBeClickable(albumPage.MY_SHOW_FIRST_EPISODE())).click();

        //打开播放队列
        wait.until(ExpectedConditions.elementToBeClickable(playerPage.QUEUE_BTN())).click();

        //左滑第一条声音
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.FIRST_EPISODE_PLAY_QUEUE()));
        WebElement EPISODE_LIST_PLAY_QUEEN = iosDriver.findElement(playerPage.EPISODE_LIST_PLAY_QUEEN());

        JavascriptExecutor js = (JavascriptExecutor) iosDriver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((RemoteWebElement) EPISODE_LIST_PLAY_QUEEN).getId());
        js.executeScript("mobile: swipe", params);

        //点击 Remove 删除该声音
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.REMOVE_PLAY_QUEUE())).click();

        //退出回到大播放页
        iosDriver.findElement(playerPage.QUEEN_BACK_BTN()).click();

        //验证当前播放声音变为原来的第2条
        wait.until(ExpectedConditions.presenceOfElementLocated(playerPage.EPISODE_NAME_PLAYER()));
        String EPISODE_NAME = iosDriver.findElement((playerPage.EPISODE_NAME_PLAYER()))
                .getAttribute("value").replace(" ", "");
        Assert.assertTrue("验证当前声音名称为原来的第2条", EPISODE_NAME.equals(Utils.getProperties("MY_SHOW_SECOND_EPISODE_NAME")));

    }


}

