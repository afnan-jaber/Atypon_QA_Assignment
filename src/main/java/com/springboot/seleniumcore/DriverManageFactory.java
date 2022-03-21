package com.springboot.seleniumcore;

/**
 * DriverManageFactory to create a driver.
 *
 */
public class DriverManageFactory {

    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            case INTERNET_EXPLORER:
                driverManager = new InternetExplorerDriverManger();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
