package com.springboot.common;

import com.springboot.seleniumcore.DriverManageFactory;
import com.springboot.seleniumcore.DriverManager;
import com.springboot.seleniumcore.DriverType;
import com.springboot.utils.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

import static com.springboot.utils.PropertiesReader.ReadData;

/*
 * This class will include the actions that can be used in test classes .
 * */
@Listeners(value = com.springboot.utils.TestListener.class)
public class BaseTest {
    public String baseUrl;
    public WebDriver driver;
    public DriverManager driverManager;
    public String testDataPath = "properties/testData.properties";

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws Exception {
        baseUrl = ReadData("BASE_URL", "properties/config.properties");
        setBrowser(browser);
        Log.info( browser +" browser was started successfully." );
        driver = driverManager.getWebDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            Log.info("driver is closed/quit.");
            driverManager.quitWebDriver();
        }
    }

    @BeforeMethod
    public void setUpTestCase(ITestResult result) {
        Log.startTestCase(result);
        driver.get(baseUrl);
        Log.info("Web Test session started with URL: " + baseUrl);
    }

    @AfterMethod
    public void endTestCase(ITestResult result) {
        Log.endTestCase(result);
        if(ITestResult.FAILURE==result.getStatus()) {
            takeScreenShot(result);
        }
    }


    public void verifyCurrentUrl(String expectedUrl) {
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

    public void setBrowser(String browser) {
      //  String browser = ReadData("BROWSER", "properties/config.properties");
        if (browser.equalsIgnoreCase("chrome")) {
            driverManager = DriverManageFactory.getDriverManager(DriverType.CHROME);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverManager = DriverManageFactory.getDriverManager(DriverType.FIREFOX);
        } else if (browser.equalsIgnoreCase("internet explorer")) {
            driverManager = DriverManageFactory.getDriverManager(DriverType.INTERNET_EXPLORER);
        }
    }

    public void takeScreenShot(ITestResult result){
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
