package com.spring.springboot.testautomation.pages.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.webframework.actions.PageActions;
import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class BasePage {

    @LazyAutowired
    private ApplicationContext appContext;

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected PageActions pageActions;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.webDriver, this);
    }

    protected abstract boolean isAt();

    protected <T> T getBean(Class<T> tClass) {
        return this.appContext.getBean(tClass);
    }

}
