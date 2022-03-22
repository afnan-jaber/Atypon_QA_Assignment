package com.springboot.common;

import com.springboot.seleniumcore.DriverManageFactory;
import com.springboot.seleniumcore.DriverManager;
import com.springboot.seleniumcore.DriverType;
import com.springboot.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

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
    public TestHelper testHelper = new TestHelper();

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
            testHelper.takeScreenShot(driver,result);
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
}
