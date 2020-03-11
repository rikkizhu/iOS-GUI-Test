package com.***REMOVED***.uitest.ios.elements;


import org.openqa.selenium.By;

public class AccountPage {
    public By EMAIL_LOGIN_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Continue with Email']");
    }

    public By EMAIL_INPUT() {
        return By.xpath("/XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    }

    public By CONTINUE_BUTTON(){
        return By.xpath("//XCUIElementTypeButton[@name='Continue']");
    }

    public By PASSWORD_INPUT(){
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
    }

    public By LOGIN_BTN(){
        return By.xpath("//XCUIElementTypeButton[@name='Log In']");
    }

    public By TOURIST_LOGIN_BTN(){
        return By.xpath("//XCUIElementTypeButton[@name='Skip For Now']");
    }
}
