package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LibraryPage {
    public By Library_TAB_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Library'");
    }

    public By FOLLOW_HINTS_LIBRARY() {
        return MobileBy.AccessibilityId("You can easily access all your favorite podcasts here");
    }

    public By View_As_Shows_Btn() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='View As Shows'");
    }

    public By FOLLOWED_SHOWS_CELL() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeCell'");
    }

}
