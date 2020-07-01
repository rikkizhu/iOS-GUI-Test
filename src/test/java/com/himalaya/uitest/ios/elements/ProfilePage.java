package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
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

    public By LOCATION_BUTTON(){
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='Location'");
    }

    public By LOCATION_USA(){
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='United States'");
    }

    public By LOCATION_HONGKONG(){
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='Hong Kong'");
    }

    public  By LOCATION_BACK_BTN(){
        return By.xpath("//XCUIElementTypeNavigationBar[@name='Location']/XCUIElementTypeButton");
    }

    public By SETTING_BACK_BTN(){
        return By.xpath("//XCUIElementTypeNavigationBar[@name='Settings']/XCUIElementTypeButton");
    }

}
