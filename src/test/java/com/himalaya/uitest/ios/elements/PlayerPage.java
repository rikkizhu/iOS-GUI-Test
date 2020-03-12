package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class PlayerPage {
    public By PLAYER_PROGRESS() {
        return MobileBy.AccessibilityId("Progress");
    }

    public By PLAY_PAUSE_BTN(){
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
    }
}
