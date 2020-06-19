package com.***REMOVED***.uitest.ios.elements;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AccountPage {
    public By EMAIL_LOGIN_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Continue with Email']");
    }

    public By EMAIL_INPUT() {
        return By.xpath("/XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    }

    public By  EMAIL_INPUT_HALF_SCREEN(){
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    }

    public By CONTINUE_BUTTON() {
        return By.xpath("//XCUIElementTypeButton[@name='Continue']");
    }

    public By PASSWORD_INPUT() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
    }

    public By PASSWORD_INPUT_HALF_SCREEN(){
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
    }

    public By LOGIN_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Log In']");
    }

    public By TOURIST_LOGIN_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Skip For Now']");
    }

    public By SKIP_BTN_ON_GUIDE() {
        return MobileBy.AccessibilityId("Skip");
    }

    public By CATEGORY_TITLE_ON_GUIDE() {
        return MobileBy.AccessibilityId("What categories are you interested in?");
    }

    public By SELECT_SHOW_TITLE_ON_GUIDE() {
        return MobileBy.AccessibilityId("Select some of your future-favorite shows.");
    }

    public By SHOW_SUGGESTIONS_TITLE_ON_GUIDE() {
        return MobileBy.AccessibilityId("Need suggestions?");
    }

    public By SIGH_UP() {
        return MobileBy.AccessibilityId("Sign Up");
    }

    public By CATEGORIES_ON_GUIDE() {
        return MobileBy.className("XCUIElementTypeCell");
    }

    public By SHOW1_ON_GUIDE() {
        return MobileBy.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
    }

    public By SHOW2_ON_GUIDE() {
        return MobileBy.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
    }

    public By DONE_BTN() {
        return MobileBy.AccessibilityId("Done!");
    }

    public By FB_ACCOUNT() {
        return By.xpath("//XCUIElementTypeOther[@name='main']/XCUIElementTypeTextField");
    }

    public By FB_PASSWORD() {
        return By.xpath("//XCUIElementTypeOther[@name='main']/XCUIElementTypeSecureTextField");
    }

    public By FB_LOGIN() {
        return MobileBy.AccessibilityId("Log In");
    }

    public By FB_LOGIN_BTN() {
        return MobileBy.AccessibilityId("Continue with Facebook");
    }

    public By FB_CONTINUE() {
        return By.xpath("//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[4]/XCUIElementTypeButton");
    }

    public By CHOOSE_MULTI_ALBUM_HINT() {
        return MobileBy.AccessibilityId("Use ***REMOVED*** as...");
    }

    public By FIRST_MULTI_ALBUM_ACCOUNT() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]");
    }

    public By FB_OPEN(){
        return By.xpath("//XCUIElementTypeButton[@name='Open']");
    }

}
