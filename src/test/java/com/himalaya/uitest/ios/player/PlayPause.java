package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlayPause extends AbstractTestCase {
    Utils utils = new Utils();

    @BeforeMethod
    public void setup(){
        // 邮箱登录
       utils.loginByEmail(iosDriver);

        //进入 myshow
       utils.enterMyShow(iosDriver);
    }

    @Test(description = "播放和暂停")
    public void testPlayPause(){

    }

}
