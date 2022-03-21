package com.springboot.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.springboot.utils.PropertiesReader.ReadData;


/**
 *
 * ExtentReport to setup the extent report.
 */
public class ExtentReport {

    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir") +
                "/Reports/ExecutionReport_" + actualDate + ".html";

        ExtentHtmlReporter htmlReporter;
        htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Executed on Environment: ", ReadData("BASE_URL", "properties/config.properties"));
        extent.setSystemInfo("Executed on Browser: ", ReadData("BROWSER", "properties/config.properties"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        return extent;
    }
}