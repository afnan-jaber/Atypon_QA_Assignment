package com.springboot.seleniumcore;

import org.openqa.selenium.chrome.ChromeDriver;

import static com.springboot.utils.PropertiesReader.ReadData;

/**
 * ChromeDriverManager handles creating a chrome driver.
 *
 */
public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        try {
            setBrowserPath();
            this.driver = new ChromeDriver();
        } catch (Exception e) {
            throw new RuntimeException("Please check Browser is exist Browser Unable to start");
        }
    }

    @Override
    public void setBrowserPath() throws Exception {
        String osType = OsValidator.getDeviceOs();
        if (osType.equalsIgnoreCase("mac")) {
            System.setProperty(ReadData("CHROME_DRIVER_PATH", configFilePath), ReadData("CHROME_DRIVER_MAC_LINK", configFilePath));
        } else if (osType.equalsIgnoreCase("windows")) {
            System.setProperty(ReadData("CHROME_DRIVER_PATH", configFilePath), ReadData("CHROME_DRIVER_WINDOWS_LINK", configFilePath));
        }
    }
}
