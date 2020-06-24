package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class DiscoverPage {

    public By DISCOVER_TAB_BTN(){
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Discover'");
    }

}
