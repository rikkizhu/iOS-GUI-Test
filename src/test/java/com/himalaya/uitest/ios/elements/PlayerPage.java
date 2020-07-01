package com.***REMOVED***.uitest.ios.elements;

import com.***REMOVED***.uitest.ios.Utils;
import com.sun.org.apache.regexp.internal.RE;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.UnableToSetCookieException;

public class PlayerPage {
    public By PLAYER_PROGRESS() {
        return MobileBy.AccessibilityId("Progress");
    }

    public By PLAY_PAUSE_BTN() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
    }

    public By PRE_SEEK_PLAYER() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name=='player ic prev15sec'");
    }

    public By SEEK_BTN_IN_MINIBAR() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name CONTAINS 'playbar ic prev15sec'");
    }

    public By PAUSE_BTN_IN_MINIBAR() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name CONTAINS 'playbar btn pause'");
    }

    public By PLAY_BTN_IN_MINIBAR() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name CONTAINS 'playbar btn play'");
    }

    public By CLOSE_BTN_IN_MINIBAR() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name CONTAINS 'playbar btn close'");
    }

    public By IMAGE_BTN_IN_MINIBAR() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]");
    }

    public By SWITCH_PRE_EPISODE_BTN() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]");
    }

    public By SWITCH_NEXT_EPISODE_BTN() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[3]");
    }

    public By EPISODE_NAME_PLAYER() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    }
}
