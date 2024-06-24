package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class BrowserOptionsConfig {

    @Bean
    @ConditionalOnProperty(name = "web.browserType", havingValue = "chrome")
    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    @Bean
    @ConditionalOnProperty(name = "web.browserType", havingValue = "firefox")
    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }

}
