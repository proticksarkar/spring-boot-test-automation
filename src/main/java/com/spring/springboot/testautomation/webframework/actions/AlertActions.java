package com.spring.springboot.testautomation.webframework.actions;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

@Slf4j
@LazyComponent
public class AlertActions {

    @LazyAutowired
    private WebDriver webDriver;
    @LazyAutowired
    private WaitActions waitActions;
    @LazyAutowired
    private Alert alert;

    public AlertActions switchToAlert() {
        waitActions.waitForAlertToBePResent();
        alert = webDriver.switchTo().alert();
        log.debug("Switched to alert");
        return this;
    }

    public AlertActions acceptAlert() {
        switchToAlert();
        alert.accept();
        log.debug("Accepted alert");
        return this;
    }

    public AlertActions dismissAlert() {
        switchToAlert();
        alert.dismiss();
        log.debug("Dismissed alert");
        return this;
    }

}
