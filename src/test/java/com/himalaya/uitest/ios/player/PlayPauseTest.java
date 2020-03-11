package com.***REMOVED***.uitest.ios.player;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import org.testng.annotations.*;

public class PlayPauseTest {

    public AbstractTestCase obj = new PlayPause();

    @BeforeTest
    public void setup(){
        // 邮箱登录
        obj.loginByEmail();

        //进入 myshow
        obj.enterMyShow();
    }

    @Test(description = "播放和暂停")
    public void testPlayPause(){
    }
}
