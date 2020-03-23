package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LibraryPage {
    public By Library_TAB_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Library']");
    }

    public By FOLLOW_HINTS_LIBRARY(){
        return MobileBy.AccessibilityId("You can easily access all your favorite podcasts here");
    }

    public By TITLE_ON_LIBRARY_PAGE(){
        return By.xpath("//XCUIElementTypeStaticText[@name='Library']");
    }

    public By ZERO_SHOW_COUNT(){
        return MobileBy.AccessibilityId("0 Shows");
    }

}
