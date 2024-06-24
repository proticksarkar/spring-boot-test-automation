package com.spring.springboot.testautomation.webframework.actions;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.Set;

@Slf4j
@LazyComponent
public class WaitActions {

    @LazyAutowired
    private WebDriver webDriver;
    @LazyAutowired
    private JavascriptExecutor jsExecutor;
    @LazyAutowired
    private FluentWait<WebDriver> wait;

    public void waitForPageToBeLoaded() {
//        wait.until(driver -> {
//            return jsExecutor.executeScript("return document.readyState").equals("complete");
//        });
        wait.until(driver -> jsExecutor.executeScript("return document.readyState").equals("complete"));
        log.debug("Waited for page to be loaded");
    }

    public <T> void waitForElementToBeVisible(T elementAttr) {
        try {
            if (elementAttr instanceof By) {
                wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr));
                log.debug("Waited for element to be visible: {}", elementAttr);
            } else {
                wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
                log.debug("Waited for element to be visible: {}", elementAttr);
            }
        } catch (TimeoutException exception) {
            log.error("TimeoutException while waiting for element: {} to be visible\nException: {}",
                    elementAttr, exception.getMessage(), exception);
            throw exception;
        }
    }

    public <T> void waitForElementsToBeVisible(T elementAttr) {
        try {
            if (elementAttr instanceof By) {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) elementAttr));
                log.debug("Waited for elements to be visible: {}", elementAttr);
            } else {
                wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementAttr));
                log.debug("Waited for elements to be visible: {}", elementAttr);
            }
        } catch (TimeoutException exception) {
            log.error("TimeoutException while waiting for elements: {} to be visible\nException: {}",
                    elementAttr, exception.getMessage(), exception);
            throw exception;
        }
    }

    public <T> void waitForTextInElementToBePresent(T elementAttr, String searchText) {
        try {
            if (elementAttr instanceof By) {
                wait.until(ExpectedConditions.textToBePresentInElementLocated((By) elementAttr, searchText));
            } else {
                wait.until(ExpectedConditions.textToBePresentInElement((WebElement) elementAttr, searchText));
            }
        } catch (TimeoutException exception) {
            throw exception;
        }
    }

    public <T> void waitForElementToBeClickable(T elementAttr) {
        try {
            if (elementAttr instanceof By) {
                wait
                        .ignoring(ElementClickInterceptedException.class)
                        .until(ExpectedConditions.elementToBeClickable((By) elementAttr));
            }
            else {
                wait
                        .ignoring(ElementClickInterceptedException.class)
                        .until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));
            }
        } catch (TimeoutException exception) {
            throw exception;
        }
    }

    public void waitForAlertToBePResent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (NoAlertPresentException noAlertPresentException) {
            throw noAlertPresentException;
        } catch (TimeoutException timeoutException) {
            throw timeoutException;
        }
    }

    public <T> void waitForElementToBeInvisible(T elementAttr) {
        try {
            if (elementAttr instanceof By) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated((By) elementAttr));
            } else {
                wait.until(ExpectedConditions.invisibilityOf((WebElement) elementAttr));
            }
        } catch (TimeoutException exception) {
            throw exception;
        }
    }

    public void waitForElementsToBeInvisible(WebElement elementAttr) {
        try {
            wait.until(ExpectedConditions.invisibilityOfAllElements((WebElement) elementAttr));
        } catch (TimeoutException exception) {
            throw exception;
        }
    }

    public void waitForElementWithTextToBeInvisible(By elementAttr, String text) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementWithText((By) elementAttr, text));
        } catch (TimeoutException exception) {
            throw exception;
        }
    }

    public void waitForExistingWindowsToClose(Set<String> existingWindows) {
        wait.until((webDriver) -> {
            Set<String> allWindows = webDriver.getWindowHandles();
            allWindows.removeAll(existingWindows);
            return allWindows.size() > 0 ? allWindows.iterator().next() : null;
        });


        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (NoAlertPresentException noAlertPresentException) {
            throw noAlertPresentException;
        } catch (TimeoutException timeoutException) {
            throw timeoutException;
        }
    }

}
