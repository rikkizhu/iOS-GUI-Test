package com.***REMOVED***.uitest.ios.elements;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AccountPage {
    public By EMAIL_LOGIN_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Continue with Email'");
    }

    public By EMAIL_INPUT() {
        return MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField'");
    }

    public By CONTINUE_BUTTON() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Continue'");
    }

    public By PASSWORD_INPUT() {
        return MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeSecureTextField'");
    }

    public By LOGIN_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Log In'");
    }

    public By TOURIST_LOGIN_BTN() {
        return MobileBy.AccessibilityId("Skip For Now");
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

    public By SHOWS_ON_GUIDE() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeCell'");
    }

    public By DONE_BTN() {
        return MobileBy.AccessibilityId("Done!");
    }

    public By FB_LOGIN_BTN() {
        return MobileBy.AccessibilityId("Continue with Facebook");
    }

    public By CHOOSE_MULTI_ALBUM_HINT() {
        return MobileBy.AccessibilityId("Use ***REMOVED*** as...");
    }

    public By FIRST_MULTI_ALBUM_ACCOUNT() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]");
    }

    public By FB_OPEN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Open'");
    }

}
