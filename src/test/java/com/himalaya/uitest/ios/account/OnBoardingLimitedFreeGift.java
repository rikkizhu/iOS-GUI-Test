package com.***REMOVED***.uitest.ios.account;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Steps;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = {"account"})
public class OnBoardingLimitedFreeGift extends AbstractTestCase {
    Steps steps = new Steps();

    @BeforeMethod
    public void setUp() {
        try {
            steps.logOut(iosDriver);
        } catch (Exception e) {
        }
    }

    @AfterMethod
    public void tearDown() {
        steps.logOut(iosDriver);
    }

    @Test(description = "新手限免礼包")
    public void testOnBoardingLimitedFreeGift() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        // 点击 "邮箱登录"按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT())).clear();
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

        //选择一个限免专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.FREE_FIRST_COURSE_HINT()));
        iosDriver.findElement(accountPage.FREE_FIRST_COURSE()).click();

        //验证进入专辑页，且自动关注
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.PLAY_COUNT()));
        Assert.assertTrue(iosDriver.findElements(albumPage.FOLLOWING_BTN()).size() > 0, "验证进入专辑页，且自动关注");

        //退出专辑页
        List<IOSElement> BACKWARD_BTN_TYPE = iosDriver.findElements(albumPage.BACKWARD_BTN_TYPE());
        BACKWARD_BTN_TYPE.get(0).click();

        //进入membership
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.MEMBERSHIP_BTN())).click();

        //验证membership列表中有一个专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Memberships_TITLE()));
        Assert.assertTrue(iosDriver.findElements(profilePage.MEMBERSHIP_TRANSACTIONS_CELL()).size() == 1,
                "验证membership列表中有一个专辑");

        //进入交易记录
        iosDriver.findElement(profilePage.TRANSACTION_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.TRANSACTIONS_TITLE()));
        Thread.sleep(1000);
        Assert.assertTrue(iosDriver.findElements(profilePage.MEMBERSHIP_TRANSACTIONS_CELL()).size() == 1,
                "验证transactions列表中有一个专辑");
    }
}
