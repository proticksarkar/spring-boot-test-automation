package com.spring.springboot.testautomation.webframework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;

@LazyComponent
public class ExtentReportManager {

    private static ExtentReports extentReports;

    public ExtentReportManager(ExtentReports extentReports) {
        this.extentReports = extentReports;
    }

    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

}
