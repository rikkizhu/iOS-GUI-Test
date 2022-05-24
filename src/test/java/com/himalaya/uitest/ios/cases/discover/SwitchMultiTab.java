package com.xxxx.uitest.ios.cases.discover;

import com.xxxx.uitest.ios.BaseTestCase;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SwitchMultiTab extends BaseTestCase {

    @Test(description = "多 tab 切换")
    public void testSwitchMultiTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //获取第2个tab的第一个卡片标题
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_SECOND_TAB())).click();
        Thread.sleep(2000);
        List<IOSElement> secondStaticTexts =iosDriver.findElements(discoverPage.DISCOVER_STATIC_TEXT());
        String title1 = secondStaticTexts.get(0).getAttribute("value");

        //获取第3个tab的第一个卡片标题
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_THIRD_TAB())).click();
        Thread.sleep(2000);
        List<IOSElement> thirdStaticTexts = iosDriver.findElements(discoverPage.DISCOVER_STATIC_TEXT());
        String title2 = thirdStaticTexts.get(0).getAttribute("value");

        Assert.assertFalse(title1.equals(title2),"验证切换成功，不同tab下的第1个卡片标题不相等");
    }

}
