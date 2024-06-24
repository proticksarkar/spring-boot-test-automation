package com.spring.springboot.testautomation.webframework.listeners;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@Slf4j
@LazyComponent
public class TestNGListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult testResult) {
        super.onTestStart(testResult);
        log.info("Started test execution: {}", testResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        super.onTestSuccess(testResult);
        log.info("Finished test execution: {}", testResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        super.onTestSkipped(testResult);
        log.info("Skipped test execution: {}", testResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        log.error("Failed test execution: {} due to exception: {}", testResult.getName(), testResult.getThrowable().toString());
    }

}
