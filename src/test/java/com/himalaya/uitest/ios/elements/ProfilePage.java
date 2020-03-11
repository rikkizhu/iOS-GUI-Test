package com.***REMOVED***.uitest.ios.elements;

import org.openqa.selenium.By;

public class ProfilePage {
    public By PROFILE_BTN() {
        return By.xpath("//XCUIElementTypeButton[@name='Profile']");
    }

    public By MYSHOW_BTN(){
        return By.xpath("//XCUIElementTypeButton[@name='My Show']");
    }

    public By RECORD_BTN_IN_MYSHOW(){
        return By.xpath("//XCUIElementTypeButton[@name='Record']");
    }
}
