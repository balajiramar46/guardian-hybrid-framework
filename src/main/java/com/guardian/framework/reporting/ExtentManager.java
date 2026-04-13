package com.guardian.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    static {
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
        spark.config().setReportName("Guardian Hybrid Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
}