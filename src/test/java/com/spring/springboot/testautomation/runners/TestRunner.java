package com.spring.springboot.testautomation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = {
                "com.spring.springboot.testautomation.webframework.cucumber.properties",
                "com.spring.springboot.testautomation.webframework.hooks",
                "com.spring.springboot.testautomation.steps.applications.theinternetherokuapp.config",
                "com.spring.springboot.testautomation.steps.applications.theinternetherokuapp",
                "com.spring.springboot.testautomation.steps.applications.excel"
        },
        tags = "@regression",
        plugin = {
                "pretty",
                "com.spring.springboot.testautomation.webframework.listeners.TestListener",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/test-artifacts/reports/cucumber-reports/cucumber-result.json",
                "html:target/test-artifacts/reports/cucumber-reports/cucumber-result.html",
                "timeline:target/test-artifacts/reports/cucumber-reports/cucumber-result-timeline",
                "rerun:target/test-artifacts/reports/cucumber-reports/rerun.txt"
        }
)
// Uncomment the below line if you want to print logs from TestNGListener class
// @Listeners(TestNGListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
