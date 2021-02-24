package com.***REMOVED***.uitest.ios.cases.discover;

import com.***REMOVED***.uitest.ios.BaseTestCase;
import com.***REMOVED***.uitest.ios.Utils;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DiscoverScrollUpDown extends BaseTestCase {
    Utils utils = new Utils();
    @Test(description = "discover页上下滑动")
    public void testDiscoverScrollUpDown() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //获取第2个tab的第一个卡片标题
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_SECOND_TAB())).click();
        Thread.sleep(2000);
        List<IOSElement> secondStaticTexts =iosDriver.findElements(discoverPage.DISCOVER_STATIC_TEXT());
        String title1 = secondStaticTexts.get(0).getAttribute("value");

        //验证滑动前卡片标题存在
        Assert.assertTrue(iosDriver.findElement(discoverPage.DISCOVER_CARD_TITLE(title1)).isDisplayed(),"验证向下滑动前卡片标题存在");

        //向下滑动
        int height = iosDriver.manage().window().getSize().height;
        for (int i = 0; i < 4; i++) {
            utils.swipePageUpDown(iosDriver,height * 3 / 4, height / 4);
        }

        //验证滑动后卡片标题不存在
        Assert.assertTrue(iosDriver.findElements(discoverPage.DISCOVER_CARD_TITLE(title1)).size()<=0,"验证向下滑动后卡片标题不存在");
    }
}
