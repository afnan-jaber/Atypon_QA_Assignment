package com.springboot.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * This class implements ITestListener interface to modify the TestNG behavior.
 */
public class TestListener implements ITestListener {
    static ExtentReports report;
    ExtentTest test;

    public void onTestStart(ITestResult result) {

        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestFailure(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");

        try {
            ExtentFactory.getInstance().getExtent().info("Details of " + "Test screenshot", MediaEntityBuilder
                    .createScreenCaptureFromPath(result.getName() + ".png").build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName() + " is skipped.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        try {
            report = ExtentReport.setupExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        report.flush();
    }
}