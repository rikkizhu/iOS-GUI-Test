package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.AccountPage;
import com.***REMOVED***.uitest.ios.elements.DiscoverPage;
import com.***REMOVED***.uitest.ios.elements.ProfilePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.***REMOVED***.uitest.ios.BaseTestCase.searchPage;

public class Steps {
    AccountPage accountPage = new AccountPage();
    DiscoverPage discoverPage = new DiscoverPage();
    ProfilePage profilePage = new ProfilePage();
    Utils utils = new Utils();

    public void loginByEmail(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        // 点击 "邮箱登录"按钮
        new WebDriverWait(iosDriver, 15).until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT())).clear();
        iosDriver.findElement(accountPage.EMAIL_INPUT()).sendKeys(Utils.getProperties("EMAIL_ACCOUNT"));

        //点击 continue 进入下一页
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.CONTINUE_BUTTON()));
        iosDriver.findElement(accountPage.CONTINUE_BUTTON()).click();

        //输入密码
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.PASSWORD_INPUT()));
        iosDriver.findElement(accountPage.PASSWORD_INPUT()).sendKeys(Utils.getProperties("EMAIL_PASSWORD"));

        //点击 Login
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.LOGIN_BTN()));
        iosDriver.findElement(accountPage.LOGIN_BTN()).click();

        //accept 弹窗
        try {
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
    }


    public void logOut(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 5);

        //点击 Settings
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN())).click();
        int height = iosDriver.manage().window().getSize().height;
        utils.swipePageUpDown(iosDriver, height * 3 / 4, height / 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Setting_Btn())).click();

        //点击退出
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.LogOut_Btn())).click();

        //确认退出
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Log_Out_Alert())).click();

        //确认回到登录页
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
    }

    public void enterMyShow(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //进入profile
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.PROFILE_BTN()));
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();

        //进入my show
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.MYSHOW_BTN()));
        iosDriver.findElement(profilePage.MYSHOW_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.RECORD_BTN_IN_MYSHOW()));
    }

    public void loginBySkip(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //点击游客登录按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.TOURIST_LOGIN_BTN()));
        iosDriver.findElement(accountPage.TOURIST_LOGIN_BTN()).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //等待进入首页
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
    }

    public void searchAlbum(IOSDriver iosDriver, String searchContent) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //进入search tab点击搜索框
        iosDriver.findElement(searchPage.SEARCH_TAB_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.SEARCH_BAR_SEARCH_TAB()));
        iosDriver.findElement(searchPage.SEARCH_BAR_SEARCH_TAB()).click();

        //输入搜索内容
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.INIT_SEARCH_INPUT()));
        iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).sendKeys(searchContent);
        List<IOSElement> SEARCH_BUTTONS = iosDriver.findElements(searchPage.KEYBOARD_SEARCH());
        SEARCH_BUTTONS.get(1).click();

        //点击进入专辑
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + searchContent + "'")));
        iosDriver.findElement(MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + searchContent + "'")).click();
    }

    public void signUpByEmail(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

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

        try {
            //跳过感兴趣的分类选择
            wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CATEGORY_TITLE_ON_GUIDE()));
            iosDriver.findElement(accountPage.SKIP_BTN_ON_GUIDE()).click();

            //跳过专辑建议选择
            wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.SHOW_SUGGESTIONS_TITLE_ON_GUIDE()));
            iosDriver.findElement(accountPage.SKIP_BTN_ON_GUIDE()).click();
        } catch (Exception e) {
        }

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();
    }

    public void fbLogin(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 60);

        //点击 FB 登录按钮
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage.FB_LOGIN_BTN())).click();

        //accept 弹窗
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        //点击open
        try {
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 5);
            wait2.until(ExpectedConditions.presenceOfElementLocated(accountPage.FB_OPEN())).click();
        } catch (Exception e) {
        }

        //点击continue
        wait.until(ExpectedConditions.presenceOfElementLocated(accountPage.CONTINUE_BUTTON())).click();

        //accept 弹窗
        try {
            WebDriverWait wait2 = new WebDriverWait(iosDriver, 3);
            wait2.until(ExpectedConditions.alertIsPresent());
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
    }

    public void switchLocation(IOSDriver iosDriver, By by) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 60);

        //切换国家
        iosDriver.findElement(profilePage.PROFILE_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.Setting_Btn())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.LOCATION_BUTTON())).click();
        utils.swipeDownToElement(iosDriver, profilePage.LOCATION_JAPAN());
        iosDriver.findElement(by).click();
        iosDriver.findElement(profilePage.LOCATION_BACK_BTN()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profilePage.SETTING_BACK_BTN())).click();
    }
}
