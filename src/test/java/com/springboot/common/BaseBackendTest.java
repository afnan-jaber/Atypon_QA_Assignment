package com.springboot.common;

import com.springboot.utils.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(value = com.springboot.utils.TestListener.class)
public class BaseBackendTest {

    @BeforeMethod
    public void setUpTestCase(ITestResult result) {
        Log.startTestCase(result);
    }

    @AfterMethod
    public void endTestCase(ITestResult result) {
        Log.endTestCase(result);
    }
}
