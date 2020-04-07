package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.*;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners({TestFailListener.class})
public class AbstractTestCase {


    protected static IOSDriver iosDriver;

    protected static AccountPage accountPage = new AccountPage();
    protected static DiscoverPage discoverPage = new DiscoverPage();
    protected static ProfilePage profilePage = new ProfilePage();
    protected static AlbumPage albumPage = new AlbumPage();
    protected static PlayerPage playerPage = new PlayerPage();
    protected static LibraryPage libraryPage = new LibraryPage();
    protected static SearchPage searchPage = new SearchPage();

    @BeforeClass
    public static void launch***REMOVED***() throws MalformedURLException {
        Utils utils = new Utils();
        iosDriver = utils.resetLaunchSimulator();

    }

    @AfterClass
    public static void quit***REMOVED***() {
        try {
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {
        }
//        iosDriver.quit();
    }

}
