package com.spring.springboot.testautomation.webframework.actions;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
@LazyComponent
public class JavascriptActions {

    @LazyAutowired
    private WebDriver webDriver;
    @LazyAutowired
    private WaitActions waitActions;

    public <T> JavascriptActions scrollIntoView(T elementAttr) {
        executeJs(elementAttr, "scrollIntoView(true);");
        log.debug("Scrolled into view of element: {} using JavascriptExecutor", elementAttr);
        return this;
    }

    public <T> JavascriptActions jsClick(T elementAttr) {
        executeJs(elementAttr, "click();");
        log.debug("Clicked element: {} using JavascriptExecutor", elementAttr);
        return this;
    }

    public <T> void highlightElement(T elementAttr, String attribute, String styleProperty, String styleValue) {
        String style = String.format("%s: %s;", styleProperty, styleValue);
        String command = String.format("setAttribute('%s', '%s');", attribute, style);
        // executeJs(elementAttr, "setAttribute('style', 'border: 2px dashed blue;');");
        log.debug("Highlighted element {}", elementAttr);
        executeJs(elementAttr, command);
    }

    private <T> void executeJs(T elementAttr, String command) {
        waitActions.waitForElementToBeVisible(elementAttr);
        if (elementAttr instanceof By) {
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0]." + command,
                            webDriver.findElement((By) elementAttr));
        } else {
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0]." + command,
                            (WebElement) elementAttr);
        }
    }

}
