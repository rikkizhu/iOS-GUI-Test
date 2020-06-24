package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;

public class ProfilePage {
    public By PROFILE_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Profile'");
    }

    public By MYSHOW_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='My Show'");
    }

    public By RECORD_BTN_IN_MYSHOW() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Record'");
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
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Log Out'");
    }

    public By HALF_SCREEN_SIGNIN(){return MobileBy.AccessibilityId("Sign in");}

}
