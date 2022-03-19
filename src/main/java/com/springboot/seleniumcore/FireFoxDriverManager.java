package com.springboot.seleniumcore;

import org.openqa.selenium.firefox.FirefoxDriver;

import static com.springboot.utils.PropertiesReader.ReadData;

/**
 * FireFoxDriverManager handles creating a firefox driver.
 *
 */
public class FireFoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        try {
            this.driver = new FirefoxDriver();
        } catch (Exception e) {
            throw new RuntimeException("Please check Browser is exist Browser Unable to start");
        }
    }

    @Override
    public void setBrowserPath() throws Exception {
        String osType = OsValidator.getDeviceOs();
        if (osType.equalsIgnoreCase("mac")) {
            System.setProperty(ReadData("FIREFOX_DRIVER_PATH", configFilePath), ReadData("FIREFOX_DRIVER_MAC_LINK", configFilePath));
        } else if (osType.equalsIgnoreCase("windows")) {
            System.setProperty(ReadData("FIREFOX_DRIVER_PATH", configFilePath), ReadData("FIREFOX_DRIVER_WINDOWS_LINK", configFilePath));
        }
    }
}
