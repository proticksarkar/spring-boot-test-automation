package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.Duration;
import java.util.Arrays;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${webDriver.timeout}")
    private long timeout;
    @Value("${webDriver.pollingInterval}")
    private long pollingInterval;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public FluentWait<WebDriver> getFluentWait(WebDriver webDriver) {
        return new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .ignoreAll(Arrays.asList(
                                NoSuchElementException.class,
                                StaleElementReferenceException.class
                        )
                );
    }

/*
    WebDriverWait approach:
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait getWebDriverWait(WebDriver webDriver) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
    }
*/

}
