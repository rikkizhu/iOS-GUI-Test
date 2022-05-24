package com.xxxx.uitest.ios;

import com.xxxx.uitest.ios.elements.*;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners({TestFailListener.class})
public class BaseTestCase {
    protected static IOSDriver iosDriver;

    protected static AccountPage accountPage = new AccountPage();
    protected static DiscoverPage discoverPage = new DiscoverPage();
    protected static ProfilePage profilePage = new ProfilePage();
    protected static AlbumPage albumPage = new AlbumPage();
    protected static PlayerPage playerPage = new PlayerPage();
    protected static LibraryPage libraryPage = new LibraryPage();
    protected static SearchPage searchPage = new SearchPage();


    @BeforeClass(alwaysRun = true)
    public static void launchxxxx() throws MalformedURLException {
        Utils utils = new Utils();
        iosDriver = utils.launchiPhoneXSMaxApp();

    }

    @AfterClass(alwaysRun = true)
    public static void quitxxxx() {
        try {
            iosDriver.switchTo().alert().accept();
        } catch (Exception e) {
        }
    }

}
