package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;

public class ProfilePage {
    public By PROFILE_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Profile']");
    }

    public By MYSHOW_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='My Show']");
    }

    public By RECORD_BTN_IN_MYSHOW() {
        return By.xpath("//XCUIElementTypeButton[@name='Record']");
    }

    public By Switch_Show_Btn() {
        return MobileBy.AccessibilityId("Switch Show");
    }

    public By Setting_Btn(){
        return MobileBy.AccessibilityId("Settings");
    }

    public By LogOut_Btn(){
        return MobileBy.AccessibilityId("Log Out");
    }

    public By Log_Out_Alert(){
        return By.xpath("//XCUIElementTypeButton[@name='Log Out']");
    }

    public By HALF_SCREEN_SIGNIN(){return MobileBy.AccessibilityId("Sign in");}

}
