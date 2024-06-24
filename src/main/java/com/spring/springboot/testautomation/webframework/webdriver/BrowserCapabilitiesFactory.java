package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import com.spring.springboot.testautomation.webframework.exceptions.UnsupportedBrowserException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import static com.spring.springboot.testautomation.webframework.constants.MessageConstants.UNSUPPORTED_BROWSER_EXCEPTION_MESSAGE;

@Profile("remote")
@ConditionalOnProperty(name = "web.executionType", havingValue = "remote")
@LazyConfiguration
public class BrowserCapabilitiesFactory {

    @LazyAutowired
    private BrowserCapabilitiesConfig capabilities;

    public DesiredCapabilities getCapabilities(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return capabilities.getChromeCapabilities();
            case "firefox":
                return capabilities.getFirefoxCapabilities();
            default:
                throw new UnsupportedBrowserException(String
                        .format(UNSUPPORTED_BROWSER_EXCEPTION_MESSAGE, browserType));
        }
    }

}
