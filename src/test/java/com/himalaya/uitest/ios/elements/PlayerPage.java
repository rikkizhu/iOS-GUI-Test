package com.xxxx.uitest.ios.elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class PlayerPage {
    public By PLAYER_PROGRESS() {
        return MobileBy.AccessibilityId("Progress");
    }

    public By PLAY_PAUSE_BTN() {
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther");
    }

    public By PRE_SEEK_PLAYER() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name=='player ic prev15sec'");
    }

    public By NEXT_SEEK_PLAYER() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name=='player ic next15sec'");
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
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]");
    }

    public By SWITCH_PRE_EPISODE_BTN() {
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]");
    }

    public By SWITCH_NEXT_EPISODE_BTN() {
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[3]");
    }

    public By EPISODE_NAME_PLAYER() {
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");
    }

    public By QUEUE_BTN() {
        return MobileBy.AccessibilityId("player ic queue");
    }

    public By REVERSE_QUEEN() {
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    }

    public By QUEEN_BACK_BTN() {
        return By.xpath("//XCUIElementTypeNavigationBar[@name='Queue']/XCUIElementTypeButton");
    }

    public By SORT_BTN_LIST_PLAY_QUEEN() {
        return MobileBy.iOSNsPredicateString("type=='XCUIElementTypeButton' AND name CONTAINS 'Reorder'");
    }

    public By EPISODE_LIST_PLAY_QUEEN() {
        return By.xpath("//XCUIElementTypeApplication[@name='xxxx']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[1]");
    }

    public By FIRST_EPISODE_PLAY_QUEUE() {
        return By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]");
    }

    public By REMOVE_PLAY_QUEUE() {
        return MobileBy.AccessibilityId("Remove");
    }

}
