package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LibraryPage {
    public By Library_TAB_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Library']");
    }

    public By FOLLOW_HINTS_LIBRARY() {
        return MobileBy.AccessibilityId("You can easily access all your favorite podcasts here");
    }

    public By TITLE_ON_LIBRARY_PAGE() {
        return By.xpath("//XCUIElementTypeStaticText[@name='Library']");
    }

    public By ZERO_SHOW_COUNT() {
        return MobileBy.AccessibilityId("0 Shows");
    }

    public By TWO_SHOW_COUNT() {
        return MobileBy.AccessibilityId("2 Shows");
    }

    public By ONE_SHOW_LIBRARY() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell");
    }

}
