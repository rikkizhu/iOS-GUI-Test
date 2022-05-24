package com.xxxx.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LibraryPage {
    public By Library_TAB_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Library'");
    }

    public By FOLLOW_HINTS_LIBRARY() {
        return MobileBy.AccessibilityId("You can easily access all your favorite podcasts here");
    }

    public By VIEW_AS_SHOWS_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='View As Shows'");
    }

    public By View_As_Episodes() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='View As Episodes'");
    }

    public By FOLLOWED_CELL() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeCell'");
    }
}
