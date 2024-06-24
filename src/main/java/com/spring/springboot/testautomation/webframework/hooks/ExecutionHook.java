package com.spring.springboot.testautomation.webframework.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.logging.WebDriverLogRetriever;
import com.spring.springboot.testautomation.webframework.reporting.ExtentReportManager;
import com.spring.springboot.testautomation.webframework.utils.ScreenshotUtil;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.springframework.context.ApplicationContext;

@Slf4j
public class ExecutionHook {

    @LazyAutowired
    private ApplicationContext appContext;
    @LazyAutowired
    private ScreenshotUtil screenshotUtil;
    @LazyAutowired
    private AllureLifecycle allureLifecycle;
    @LazyAutowired
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    @Before
    public void beforeScenario(Scenario scenario) {
        extentTest = extentReports.createTest(scenario.getName());
//        allureLifecycle.startTestCase(scenario.getName());
        log.info("Started test execution: {}", scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            attachScreenshot(scenario);
            log.error("Test step failed");
        }
        else {
            log.debug("Test step passed");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Failed test execution: {}", scenario.getName());
        }
        else {
            log.debug("Finished test execution: {}", scenario.getName());
        }
        attachBrowserLog(scenario);
        appContext.getBean(WebDriver.class).quit();
        log.info("Finished test execution: {}", scenario.getName());
    }

    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReport();
//        Allure.getLifecycle().writeTestCase(Allure.getLifecycle().getCurrentTestCase().toString());
    }

    private void attachScreenshot(Scenario scenario) {
        scenario
                .attach(screenshotUtil.getScreenshotAsBytes(),
                        "image/png",
                        scenario.getName());
        extentTest
                .fail("Failed test screenshot:",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                        screenshotUtil.getScreenshotAsBase64(),
                                        scenario.getName())
                                .build());
        allureLifecycle
                .addAttachment("Failed test screenshot",
                        "image/png",
                        "png",
                        screenshotUtil.getScreenshotAsBytes());
        log.debug("Screenshot taken for scenario: {}", scenario.getName());
    }

    private void attachBrowserLog(Scenario scenario) {
        WebDriver webDriver = appContext.getBean(WebDriver.class);
        StringBuilder logMessage = new StringBuilder();
        for (LogEntry e : WebDriverLogRetriever.getBrowserLogs(webDriver)) {
            logMessage.append("[").append(e.getLevel()).append("] -- ").append(e.getMessage());
            logMessage.append("\n");
        }
        scenario.attach(logMessage.toString(), "text/plain", "Browser Console Log");
        log.debug("Browser logs attached for scenario: {}", scenario.getName());
    }

}
