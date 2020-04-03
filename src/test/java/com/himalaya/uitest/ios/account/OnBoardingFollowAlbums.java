package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//40版本后加了AB测试，不一定会走新手引导
public class OnBoardingFollowAlbums extends AbstractTestCase {
    @Test(description = "新手引导关注专辑")
    public void testFollowAlbum_OnBoarding() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 10);

        // 点击 "邮箱登录"按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT()));
        iosDriver.findElement(accountPage.EMAIL_INPUT()).sendKeys(RandomStringUtils.randomAlphanumeric(6) + "@hi.com");

        //点击 continue 进入下一页
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.CONTINUE_BUTTON()));
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //输入密码
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.PASSWORD_INPUT()));
        iosDriver.findElement(accountPage.PASSWORD_INPUT()).sendKeys(Utils.getProperties("EMAIL_PASSWORD"));

        //点击 SignUp
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.SIGH_UP()));
        iosDriver.findElement(accountPage.SIGH_UP()).click();

        //跳过感兴趣的分类选择
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CATEGORY_TITLE_ON_GUIDE()));
        iosDriver.findElement(accountPage.SKIP_BTN_ON_GUIDE()).click();

        //选择感兴趣的专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.SHOW_SUGGESTIONS_TITLE_ON_GUIDE()));
        iosDriver.findElement(accountPage.SHOW1_ON_GUIDE()).click();
        iosDriver.findElement(accountPage.SHOW2_ON_GUIDE()).click();

        //点击完成按钮
        iosDriver.findElement(accountPage.DONE_BTN()).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //进入 library 页
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN()));
        iosDriver.findElement(libraryPage.Library_TAB_BTN()).click();

        //验证有关注两个专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.TITLE_ON_LIBRARY_PAGE()));
        Assert.assertTrue(iosDriver.findElement(libraryPage.TWO_SHOW_COUNT()).isDisplayed(), "验证专辑专注数为2");
        Assert.assertTrue(iosDriver.findElement(libraryPage.ONE_SHOW_LIBRARY()).isDisplayed(), "验证library有关注的专辑存在");

    }
}
