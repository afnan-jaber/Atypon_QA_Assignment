package com.springboot.seleniumcore;

import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.springboot.utils.PropertiesReader.ReadData;

/**
 * InternetExploreDriverManger handles creating a internet explorer driver.
 *
 */
public class InternetExploreDriverManger extends DriverManager {

    @Override
    protected void createWebDriver() {
        try {
            this.driver = new InternetExplorerDriver();
        } catch (Exception e) {
            throw new RuntimeException("Please check Browser is exist Browser Unable to start");
        }
    }

    @Override
    public void setBrowserPath() throws Exception {
        String osType = OsValidator.getDeviceOs();
        if (osType.equalsIgnoreCase("windows")) {
            System.setProperty(ReadData("IEDriverPath", "config.properties"), ReadData("IEBrowserPathWindows", "config.properties"));
        }
    }
}
