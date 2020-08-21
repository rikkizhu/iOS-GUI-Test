package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class DiscoverPage {

    public By DISCOVER_TAB_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Discover'");
    }

    public By DISCOVER_FIRST_TAB() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton");
    }

    public By DISCOVER_SECOND_TAB() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton");
    }

    public By DISCOVER_THIRD_TAB() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton");
    }

    public By DISCOVER_STATIC_TEXT() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText'");
    }

    public By SEE_ALL_BUTTON() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name =='See All'");
    }

    public By SEE_ALL_PAGE_TITLE_BAR() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeNavigationBar'");
    }

    public By SEE_ALL_PAGE_IMAGE() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeImage'");
    }

    public By DISCOVER_CARD_TITLE(String name) {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + name + "'");
    }


}
