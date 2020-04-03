package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//40版本后加了AB测试，不一定会走新手引导
public class OnBoardingSkipFollow extends AbstractTestCase {
    @Test(description = "新手引导跳过关注")
    public void testSkipFollow_OnBoarding() {
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

        //选择感兴趣的分类
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CATEGORIES_ON_GUIDE()));
        List<WebElement> categoryList = iosDriver.findElements(accountPage.CATEGORIES_ON_GUIDE());
        categoryList.get(0).click();
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //跳过专辑建议选择
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.SELECT_SHOW_TITLE_ON_GUIDE()));
        iosDriver.findElement(accountPage.SKIP_BTN_ON_GUIDE()).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //进入 library 页
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.Library_TAB_BTN()));
        iosDriver.findElement(libraryPage.Library_TAB_BTN()).click();

        //验证没有关注专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(libraryPage.TITLE_ON_LIBRARY_PAGE()));
        Assert.assertTrue(iosDriver.findElement(libraryPage.FOLLOW_HINTS_LIBRARY()).isDisplayed(), "验证关注专辑提示存在，表明没有关注专辑");
        Assert.assertTrue(iosDriver.findElement(libraryPage.ZERO_SHOW_COUNT()).isDisplayed(), "验证关注专辑计数为0");
    }
}
