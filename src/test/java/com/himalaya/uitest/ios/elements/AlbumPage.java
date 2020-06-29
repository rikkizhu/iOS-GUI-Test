package com.***REMOVED***.uitest.ios.elements;

import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class AlbumPage {
    public By FIRST_EPISODE() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]");
    }

    public By MY_SHOW_FIRST_EPISODE() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("MY_SHOW_FIRST_EPISODE_NAME") + "'");
    }

    public By MY_SHOW_THIRD_EPISODE() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("MY_SHOW_THIRD_EPISODE_NAME") + "'");
    }

    public By FOLLOW_BTN() {
        return MobileBy.AccessibilityId("Follow");
    }

    public By FOLLOWING_BTN() {
        return MobileBy.AccessibilityId("Following");
    }

    public By SETTING_BTN_BEHIND_FOLLOWING() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]");
    }

    public By LISTENERS_ALSO_FOLLOWED() {
        return MobileBy.AccessibilityId("Listeners Also Followed:");
    }

    public By BACKWARD_BTN_TYPE() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton'");
    }

    public By PLAY_COUNT() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name CONTAINS 'Plays'");
    }

    public By ALBUM_TITLE_ALBUM_PAGE() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeStaticText' AND name=='" + Utils.getProperties("SEARCH_ALBUM") + "'");
    }

    public By DETAIL_MORE_ALBUM_PAGE() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton[2]");
    }

    public By SEARCH_EPISODES_IN_SHOW_BTN() {
        return MobileBy.AccessibilityId("Search episodes in this show");
    }

    public By SEARCH_FIELD_IN_SHOW() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeSearchField' AND name=='Search episodes in this show'");
    }

}
