package com.***REMOVED***.uitest.ios.elements;

import org.openqa.selenium.By;

public class DiscoverPage {
    public By TRENDING_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Trending']");
    }

    public By DISCOVER_TAB_BTN(){
        return By.xpath("//XCUIElementTypeButton[@name='Discover']");
    }
}
