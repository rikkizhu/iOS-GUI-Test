package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.AccountPage;
import com.***REMOVED***.uitest.ios.elements.DiscoverPage;
import com.***REMOVED***.uitest.ios.elements.ProfilePage;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class AbstractTestCase {


    protected static IOSDriver iosDriver;

    protected static AccountPage accountPage = new AccountPage();
    protected static DiscoverPage discoverPage = new DiscoverPage();
    protected static ProfilePage profilePage = new ProfilePage();

    @BeforeClass
    public static void launch***REMOVED***() throws MalformedURLException {
        Utils utils = new Utils();
        iosDriver=utils.resetLaunchSimulator();
    }

    //@AfterClass
    public static void quit***REMOVED***() {
        iosDriver.quit();
    }

}
