package com.spring.springboot.testautomation.runners;

import io.cucumber.testng.*;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.function.Predicate;

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
                "rerun:target/test-artifacts/reports/cucumber-reports/rerun.txt",
        }
)
// Uncomment the below line if you want to print logs from TestNGListener class
// @Listeners(TestNGListener.class)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    private io.cucumber.testng.TestNGCucumberRunner testNGCucumberRunner;
    private static final Predicate<Pickle> isSerial = p ->
//            p.getTags().stream().anyMatch(p1 -> p1.equalsIgnoreCase("@serial") || p1.equalsIgnoreCase("@chrome") || p1.equalsIgnoreCase("@firefox"));
            p.getTags().stream().anyMatch(p1 -> p1.equalsIgnoreCase("@serial"));
    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() {
        this.testNGCucumberRunner = new io.cucumber.testng.TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Run Parallel", dataProvider = "parallelScenarios")
    public void runParallelScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @Test(groups = "cucumber", description = "Run Serial", dataProvider = "serialScenarios")
    public void runSerialScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider(parallel = true)
    public Object[][] parallelScenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return filter(testNGCucumberRunner.provideScenarios(), isSerial.negate());
    }

    @DataProvider
    public Object[][] serialScenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return filter(testNGCucumberRunner.provideScenarios(), isSerial);
    }

    private Object[][] filter(Object[][] scenarios, Predicate<Pickle> accept) {
        return Arrays.stream(scenarios).filter(objects -> {
            PickleWrapper candidate = (PickleWrapper) objects[0];
            return accept.test(candidate.getPickle());
        }).toArray(Object[][]::new);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }

}
