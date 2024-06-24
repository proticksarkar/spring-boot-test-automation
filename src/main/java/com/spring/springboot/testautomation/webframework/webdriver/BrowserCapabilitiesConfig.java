package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("remote")
@ConditionalOnProperty(name = "web.executionType", havingValue = "remote")
@LazyConfiguration
public class BrowserCapabilitiesConfig {

    @Bean
    @ConditionalOnProperty(name = "remote.browser", havingValue = "chrome")
    public DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions());
        return capabilities;
    }

    @Bean
    @ConditionalOnProperty(name = "remote.browser", havingValue = "firefox")
    public DesiredCapabilities getFirefoxCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
        return capabilities;
    }

}
