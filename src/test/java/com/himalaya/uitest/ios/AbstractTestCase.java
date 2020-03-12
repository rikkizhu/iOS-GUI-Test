package com.***REMOVED***.uitest.ios;

import com.***REMOVED***.uitest.ios.elements.*;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class AbstractTestCase {


    protected static IOSDriver iosDriver;

    protected static AccountPage accountPage = new AccountPage();
    protected static DiscoverPage discoverPage = new DiscoverPage();
    protected static ProfilePage profilePage = new ProfilePage();
    protected static AlbumPage albumPage = new AlbumPage();
    protected static PlayerPage playerPage = new PlayerPage();

    @BeforeClass
    public static void launch***REMOVED***() throws MalformedURLException {
        Utils utils = new Utils();
        //todo
        iosDriver=utils.resetLaunchSimulator();
//        iosDriver=utils.noResetLaunchSimulator();
    }

    //@AfterClass
    public static void quit***REMOVED***() {
        iosDriver.quit();
    }

}
