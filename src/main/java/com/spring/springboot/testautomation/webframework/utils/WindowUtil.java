package com.spring.springboot.testautomation.webframework.utils;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@LazyComponent
public class WindowUtil {

    @Autowired
    private ApplicationContext appContext;

    public void switchByTitle(final String title) {
        WebDriver webDriver = appContext.getBean(WebDriver.class);

        webDriver
                .getWindowHandles()
                .stream()
                .map(handle -> webDriver
                        .switchTo()
                        .window(handle)
                        .getTitle())
                .filter(t -> t.startsWith(title))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("There is no such window available.");
                });
    }

    public void switchByIndex(final int index) {
        WebDriver webDriver = appContext.getBean(WebDriver.class);

        String[] handles = webDriver
                .getWindowHandles()
                .toArray(new String[0]);

        webDriver
                .switchTo()
                .window(handles[index]);
    }

}
