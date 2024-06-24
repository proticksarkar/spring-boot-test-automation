package com.spring.springboot.testautomation.webframework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
@PropertySource("classpath:extent.properties")
public class ExtentReportConfig {

    @Value("${extent.reporter.spark.out}")
    private String extentReportPath;

    @Bean
    public ExtentReports getExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ExtentTest getExtentTest(ExtentReports extentReports) {
        return extentReports.createTest("TestName"); // The test name will be overridden as per scenario
    }

}
