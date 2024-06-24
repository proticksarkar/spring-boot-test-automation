package com.spring.springboot.testautomation.webframework.listeners;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import com.spring.springboot.testautomation.webframework.annotations.WebDriverScope;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;
import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LazyComponent
public class TestListener implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        String scenarioName = getScenarioName(event.getTestCase());
        log.info("Started test execution: {}", scenarioName);
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        String scenarioName = getScenarioName(event.getTestCase());
        if (event.getResult().getStatus().is(Status.PASSED)) {
            log.info("Finished test execution: {}", scenarioName);
        } else {
            log.error("Failed test execution: {} due to exception: {}", scenarioName, event.getResult().getError());
        }
    }

    private void onTestStepFinished(TestStepFinished event) {
        if (event.getResult().getStatus().is(Status.FAILED)) {
            log.error("Test step failed");
        }
        else {
            log.debug("Test step passed");
        }
    }

    private String getScenarioName(TestCase testCase) {
        return testCase.getName().replaceAll(" ", "_");
    }

}
