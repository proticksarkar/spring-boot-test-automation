package com.spring.springboot.testautomation.webframework.logging;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

@LazyComponent
public class WebDriverLogRetriever {

    public static LogEntries getBrowserLogs(WebDriver driver) {
        return driver
                .manage()
                .logs()
                .get(LogType.BROWSER);
    }

    public static LogEntries getDriverLogs(WebDriver driver) {
        return driver
                .manage()
                .logs()
                .get(LogType.DRIVER);
    }

    public static LogEntries getServerLogs(WebDriver driver) {
        return driver
                .manage()
                .logs()
                .get(LogType.SERVER);
    }

}
