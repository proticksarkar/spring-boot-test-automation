package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import com.spring.springboot.testautomation.webframework.annotations.WebDriverScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@Profile("remote")
@ConditionalOnProperty(name = "web.executionType", havingValue = "remote")
@LazyConfiguration
public class RemotePlatformBrowserDriverConfig {

    @LazyAutowired
    private RemotePlatformCapabilitiesConfig remotePlatformCapabilitiesConfig;

    @Value("${browserstack.url}")
    private URL browserstackUrl;
    @Value("${seleniumGrid.url}")
    private URL seleniumGridUrl;

    @WebDriverScope
    @ConditionalOnProperty(name = "web.remotePlatformType", havingValue = "browserstack")
    @Primary
    public WebDriver getBrowserstackRemoteWebDriver(BrowserCapabilitiesFactory browserCapabilitiesFactory) {
        return new RemoteWebDriver(browserstackUrl, remotePlatformCapabilitiesConfig.getBrowserstackCapabilities(browserCapabilitiesFactory), false);
    }

    @WebDriverScope
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "web.remotePlatformType", havingValue = "seleniumGrid")
    @Primary
    public WebDriver getSeleniumGridRemoteWebDriver(BrowserCapabilitiesFactory browserCapabilitiesFactory) {
        return new RemoteWebDriver(seleniumGridUrl, remotePlatformCapabilitiesConfig.getSeleniumGridCapabilities(browserCapabilitiesFactory), false);
    }

}
