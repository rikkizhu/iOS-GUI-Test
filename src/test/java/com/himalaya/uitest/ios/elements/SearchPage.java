package com.***REMOVED***.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class SearchPage {

    public By SEARCH_TAB_BTN() {
        return MobileBy.AccessibilityId("Search");
    }

    public By CANCEL_SEARCH_BTN() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND label=='Cancel'");
    }

    public By INIT_SEARCH_INPUT() {
        return MobileBy.AccessibilityId("Shows, episodes, or playlists");
    }

    public By KEYBOARD_SEARCH() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND label=='Search'");
    }

    public By RESULT_SHOW_TAB() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name=='Shows'");
    }

    public By RESULT_EPISODES_TAB() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name=='Episodes'");

    }

    public By RESULT_PLAYLISTS_TAB() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name=='Playlists'");
    }

    public By RESULT_ALBUM_CELL() {
        return By.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView[2]/XCUIElementTypeCell");
    }

    public By CLEAR_TEXT_BTN() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeButton' AND name=='Clear text'");
    }

    public By RECENT_SEARCH_TITLE() {
        return MobileBy.AccessibilityId("Recent Searches");
    }

    public By SEARCH_BAR_SEARCH_TAB() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeNavigationBar' AND name=='Search'");
    }

    public By SEARCH_CONTENT_SEARCH_INPUT() {
        return MobileBy.iOSNsPredicateString("type =='XCUIElementTypeSearchField' AND name=='Search'");
    }

    public By RESULT_EPISODE_CELL_IN_ALBUM() {
        return MobileBy.xpath("//XCUIElementTypeApplication[@name='***REMOVED***']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell");
    }

}
