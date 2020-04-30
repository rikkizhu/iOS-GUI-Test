package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.AccountPage;
import com.***REMOVED***.uitest.ios.elements.DiscoverPage;
import com.***REMOVED***.uitest.ios.elements.ProfilePage;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.***REMOVED***.uitest.ios.AbstractTestCase.albumPage;
import static com.***REMOVED***.uitest.ios.AbstractTestCase.searchPage;

public class Steps {
    AccountPage accountPage = new AccountPage();
    DiscoverPage discoverPage = new DiscoverPage();
    ProfilePage profilePage = new ProfilePage();

    public void loginByEmail(IOSDriver iosDriver) {
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        // 点击 "邮箱登录"按钮
        new WebDriverWait(iosDriver, 15).until(ExpectedConditions.visibilityOfElementLocated(accountPage.EMAIL_LOGIN_BTN()));
        iosDriver.findElement(accountPage.EMAIL_LOGIN_BTN()).click();

        //输入邮箱
        wait.until(ExpectedConditions.elementToBeClickable(accountPage.EMAIL_INPUT()));
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
        wait.until(ExpectedConditions.alertIsPresent());
        iosDriver.switchTo().alert().accept();

        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_TAB_BTN()));
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

    public void searchAlbum(IOSDriver iosDriver){
        WebDriverWait wait = new WebDriverWait(iosDriver, 15);

        //点击discover上方搜索按钮，查看是否进入搜索页
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.SEARCH_BAR_DISCOVER_TAB())).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchPage.CANCEL_SEARCH_BTN())).isDisplayed();

        //输入搜索内容
        iosDriver.findElement(searchPage.INIT_SEARCH_INPUT()).sendKeys(Utils.getProperties("FOLLOW_ALBUM_ID"));
        iosDriver.findElement(searchPage.KEYBOARD_SEARCH()).click();

        //点击进入第一个
        iosDriver.findElement(searchPage.FIRST_ALBUM_SEARCHED()).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(albumPage.JOIN_MEMBERSHIP()));
    }

    public void singUpByEmail(IOSDriver iosDriver){
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
}
