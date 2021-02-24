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

    public By Setting_Btn() {
        return By.xpath("//XCUIElementTypeNavigationBar[@name=\"XMIMoreHomeView\"]/XCUIElementTypeButton");
    }

    public By LogOut_Btn() {
        return MobileBy.AccessibilityId("Log Out");
    }

    public By Log_Out_Alert() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Log Out'");
    }

    public By HALF_SCREEN_SIGNIN() {
        return MobileBy.AccessibilityId("Sign in");
    }

    public By LOCATION_BUTTON() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='Content Location'");
    }

    public By LOCATION_USA() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='United States'");
    }

    public By LOCATION_JAPAN() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='Japan'");
    }

    public By LOCATION_CHINAMAINLAND() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='China mainland'");
    }

    public By LOCATION_BACK_BTN() {
        return By.xpath("//XCUIElementTypeNavigationBar[@name='Content Location']/XCUIElementTypeButton");
    }

    public By SETTING_BACK_BTN() {
        return By.xpath("//XCUIElementTypeNavigationBar[@name='Settings']/XCUIElementTypeButton");
    }

    public By MEMBERSHIP_BTN() {
        return By.xpath("//XCUIElementTypeStaticText[@name='Memberships']");
    }

    public By MEMBERSHIP_TRANSACTIONS_CELL() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeImage'");
    }

    public By TRANSACTION_BTN() {
        return By.xpath("//XCUIElementTypeNavigationBar[@name='Memberships']/XCUIElementTypeButton[2]");
    }

    public By TRANSACTIONS_TITLE() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name =='Transactions'");
    }

    public By Memberships_TITLE() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name =='Memberships'");
    }
}
