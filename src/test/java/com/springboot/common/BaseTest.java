package com.springboot.common;

import com.springboot.seleniumcore.DriverManageFactory;
import com.springboot.seleniumcore.DriverManager;
import com.springboot.seleniumcore.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import static com.springboot.utils.PropertiesReader.ReadData;

public class BaseTest {
    public String baseUrl = ReadData("BaseUrl");
    public WebDriver driver;
    public DriverManager driverManager;

    public BaseTest() throws Exception {
    }

    @BeforeClass
    public void setUp (){
        driverManager = DriverManageFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
    }

}
