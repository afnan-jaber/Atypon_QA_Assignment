package com.springboot.common;

import com.springboot.utils.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.File;
import java.time.Duration;

public class TestHelper {

    public void verifyCurrentUrl(WebDriver driver ,String expectedUrl) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.urlContains(expectedUrl));
        } catch (Exception e) {
            Log.error("Page was not loaded, User was directed to " + driver.getCurrentUrl() + " instead of  " + expectedUrl);
        } finally {
            Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl),
                    "Verify that user is redirected to " + expectedUrl + " page.");
        }
    }

    public void takeScreenShot(WebDriver driver,ITestResult result){
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String screenShotTitle = "./Reports/" + result.getName() + ".png";
            FileHandler.copy(source, new File(screenShotTitle));
            Log.info("Please check " +screenShotTitle +" screen shot");
        } catch (Exception e) {
            Log.error("Exception while taking screenshot " + e.getMessage());
        }
    }
}
