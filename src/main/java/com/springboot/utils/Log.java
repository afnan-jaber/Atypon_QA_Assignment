package com.springboot.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.ITestResult;

public class Log {
// Initialize Log4j logs

    private static Logger Log = Logger.getLogger(Log.class.getName());//


    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(ITestResult iTestResult) {
        resetConfiguration();
        Log.info("****************************************************************************************");

        Log.info("****************************************************************************************");

        Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + iTestResult.getMethod().getMethodName() + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

        Log.info("****************************************************************************************");

        Log.info("****************************************************************************************");

    }

    //This is to print log for the ending of the test case

    public static void endTestCase(ITestResult iTestResult) {
        resetConfiguration();
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX   " + iTestResult.getMethod().getMethodName() + "   XXXXXXXXXXXXXXXXXXXXXX");
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "      XXXXXXXXXXXXXXXXXXXXXX");

    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {
        resetConfiguration();
        Log.info(message);

    }

    public static void warn(String message) {
        resetConfiguration();
        Log.warn(message);

    }

    public static void error(String message) {
        resetConfiguration();
        Log.error(message);
    }

    public static void fatal(String message) {
        resetConfiguration();
        Log.fatal(message);

    }

    public static void debug(String message) {
        resetConfiguration();
        Log.debug(message);

    }

    private static void resetConfiguration() {
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure();
    }
}

