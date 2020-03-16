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

    public By CONTINUE_BUTTON() {
        return By.xpath("//XCUIElementTypeButton[@name='Continue']");
    }

    public By PASSWORD_INPUT() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
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

    public By SUGGESTIONS_TITLE_ON_GUIDE() {
        return MobileBy.AccessibilityId("Need suggestions?");
    }

    public By SIGH_UP() {
        return MobileBy.AccessibilityId("Sign Up");
    }

}
