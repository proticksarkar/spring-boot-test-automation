package com.spring.springboot.testautomation.webframework.actions;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
@LazyComponent
public class NavigationActions {

    @LazyAutowired
    private WebDriver webDriver;
    @LazyAutowired
    private WaitActions waitActions;

    // Navigate to URL
    public NavigationActions goTo(String url) {
        waitActions.waitForPageToBeLoaded();
        webDriver
                .get(url);
        log.debug("Opened URL: {}", url);
        return this;
    }

    // Navigate forward by accessing browser history
    public NavigationActions navigateForward() {
        waitActions.waitForPageToBeLoaded();
        webDriver
                .navigate().forward();
        log.debug("Navigated forward from current page in browser history");
        return this;
    }

    // Navigate back to previous page by accessing browser history
    public NavigationActions navigateBack() {
        waitActions.waitForPageToBeLoaded();
        webDriver
                .navigate().back();
        log.debug("Navigated back from current page in browser history");
        return this;
    }

    // Refresh webpage
    public NavigationActions refreshPage() {
        waitActions.waitForPageToBeLoaded();
        webDriver
                .navigate().refresh();
        log.debug("Refreshed current page");
        return this;
    }

}
