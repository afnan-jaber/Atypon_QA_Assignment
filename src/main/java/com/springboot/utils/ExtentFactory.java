package com.springboot.utils;

import com.aventstack.extentreports.ExtentTest;

/**
 *
 * ExtentFactory to setup the extent report.
 */
public class ExtentFactory {

    private static ExtentFactory instance = new ExtentFactory();

    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    private ExtentFactory() {
    }

    public static ExtentFactory getInstance() {
        return instance;
    }

    public ExtentTest getExtent() {
        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    public void removeExtentObject() {
        extent.remove();
    }
}