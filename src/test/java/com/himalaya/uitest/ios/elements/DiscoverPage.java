package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class DiscoverPage {
    public By TRENDING_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Trending']");
    }

    public By DISCOVER_TAB_BTN(){
        return By.xpath("//XCUIElementTypeButton[@name='Discover']");
    }

    public By SEARCH_BAR_DISCOVER_TAB(){
        return MobileBy.AccessibilityId("Shows, episodes, or playlists");
    }
}
