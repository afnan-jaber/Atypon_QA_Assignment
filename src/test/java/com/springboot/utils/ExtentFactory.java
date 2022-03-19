package com.springboot.utils;

import com.aventstack.extentreports.ExtentTest;

/**
 *
 */
public class ExtentFactory {
    private static ExtentFactory instance = new ExtentFactory();
    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    //Singleton design Pattern
    //private constructor so that no one else can create object of this class
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