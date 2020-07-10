package com.***REMOVED***.uitest.ios.discover;

import com.***REMOVED***.uitest.ios.AbstractTestCase;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CardSeeAll extends AbstractTestCase {
    @Test(description = "discover 卡片 see all")
    public void testCardSeeAll() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(iosDriver, 30);

        //点击第2个tab下的第一个see all
        wait.until(ExpectedConditions.presenceOfElementLocated(discoverPage.DISCOVER_SECOND_TAB())).click();
        Thread.sleep(2000);
        List<IOSElement> seeAllButtons =iosDriver.findElements(discoverPage.SEE_ALL_BUTTON());
        seeAllButtons.get(0).click();

        //等待多tab消失后，断言是否是否成功进入 see all 页
        wait.until(ExpectedConditions.invisibilityOfElementLocated(discoverPage.DISCOVER_FIRST_TAB()));
        Assert.assertTrue(iosDriver.findElements(discoverPage.SEE_ALL_BUTTON()).size()<=0,"验证进入see all 页，see all 页不展示 see all");
        Assert.assertTrue(iosDriver.findElement(discoverPage.SEE_ALL_PAGE_TITLE_BAR()).isDisplayed(),"验证 see all 页有标题栏");
        Assert.assertTrue(iosDriver.findElements(discoverPage.SEE_ALL_PAGE_IMAGE()).size()>=3,"验证see all也有专辑封面元素，且不少于3个");

    }
}
