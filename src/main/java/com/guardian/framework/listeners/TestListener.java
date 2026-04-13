package com.guardian.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentTest;
import com.guardian.framework.reporting.ExtentManager;
import com.guardian.framework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = ExtentManager.extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.capture(result.getName());

        if (path != null) {
            test.get().fail("Test Failed. Screenshot attached")
                .addScreenCaptureFromPath(path);
        } else {
            test.get().fail("Test Failed. Screenshot not available");
        }
    }

    // 👉 PASTE HERE (INSIDE CLASS, NOT OUTSIDE)
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Flushing report...");
        ExtentManager.extent.flush();
    }
}