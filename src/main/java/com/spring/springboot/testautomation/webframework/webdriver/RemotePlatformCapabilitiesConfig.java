package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("remote")
@ConditionalOnProperty(name = "web.executionType", havingValue = "remote")
@LazyConfiguration
public class RemotePlatformCapabilitiesConfig {

    @Value("${remote.browser}")
    private String browserName;
    @Value("${remote.browserVersion}")
    private String browserVersion;
    @Value("${remote.os}")
    private String osName;
    @Value("${remote.osVersion}")
    private String osVersion;

    @Bean
    @ConditionalOnProperty(name = "web.remotePlatformType", havingValue = "browserstack")
    public DesiredCapabilities getBrowserstackCapabilities(BrowserCapabilitiesFactory browserCapabilitiesFactory) {
        DesiredCapabilities capabilities = browserCapabilitiesFactory.getCapabilities(browserName);
        capabilities.setCapability("browser_version", browserVersion);
        capabilities.setCapability("os", osName);
        capabilities.setCapability("os_version", osVersion);
        return capabilities;
    }

    @Bean
    @ConditionalOnProperty(name = "web.remotePlatformType", havingValue = "seleniumGrid")
    public DesiredCapabilities getSeleniumGridCapabilities(BrowserCapabilitiesFactory browserCapabilitiesFactory) {
        DesiredCapabilities capabilities = browserCapabilitiesFactory.getCapabilities(browserName);
        return capabilities;
    }

}
