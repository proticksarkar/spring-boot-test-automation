/*
package com.spring.springboot.testautomation.pages.applications.demoqa;

import com.spring.springboot.testautomation.webframework.actions.PageActions;
import com.spring.springboot.testautomation.webframework.logging.WebDriverLogRetriever;
import com.spring.springboot.testautomation.webframework.propertyconfig.ConfigLoader;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.models.factory.annotation.Autowired;

public abstract class BasePage {

    @Autowired
    protected ConfigLoader configLoader;

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected PageActions pageActions;

    @Autowired
    protected WebDriverLogRetriever logger;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.webDriver, this);
    }

    @PreDestroy
    protected void closeBrowser() {
        this.webDriver.quit();
    }

//    @Lookup
//    protected WebDriver getWebDriver() {
//        return null;
//    }

    protected abstract boolean isAt();

}
*/
