package com.***REMOVED***.uitest.ios;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFailListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        takePhoto();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takePhoto() {
        byte[] screenshotAs = ((TakesScreenshot) BaseTestCase.iosDriver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }

}
