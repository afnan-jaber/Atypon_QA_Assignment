package com.springboot.seleniumcore;

import org.openqa.selenium.WebDriver;

/**
 * DriverManageFactory manges driver actions.
 *
 */
public abstract class DriverManager {
    String configFilePath = "properties/config.properties";
    protected  WebDriver driver;

    protected abstract void createWebDriver() ;

    public abstract void setBrowserPath() throws Exception;

    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() {
        if (null == driver) {
            createWebDriver();
        }
        return driver;
    }
}
