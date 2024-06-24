/*
package com.spring.springboot.testautomation.tests.applications.demoqa;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.annotations.WebTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.WebDriverLogRetriever;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@WebTest
public class BaseTest {

    @LazyAutowired
    protected ApplicationContext appContext;

    protected WebDriverLogRetriever logger = LoggerFactory.getLogger(this.getClass());

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void teardown() {
        this.appContext
                .getBean(WebDriver.class)
                .quit();
    }

}
*/
