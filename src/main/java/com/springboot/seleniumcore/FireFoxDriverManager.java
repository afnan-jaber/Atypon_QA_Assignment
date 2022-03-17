package com.springboot.seleniumcore;

import org.openqa.selenium.firefox.FirefoxDriver;

import static com.springboot.utils.PropertiesReader.ReadData;

public class FireFoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        try{
        this.driver = new FirefoxDriver();
    }
        catch (Exception e){
        throw new RuntimeException("Please check Browser is exist Browser Unable to start");
    }
    }

    @Override
    public void setBrowserPath() throws Exception {
        String osType = OsValidator.getDeviceOs();
        if (osType.equalsIgnoreCase("mac")) {
            System.setProperty(ReadData("FireFoxDriverPath"), ReadData("FireFoxBrowserPathMac"));
        } else if (osType.equalsIgnoreCase("windows")) {
            System.setProperty(ReadData("FireFoxDriverPath"), ReadData("FireFoxBrowserWindows"));
        }
    }
}
