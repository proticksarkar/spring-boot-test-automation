package com.spring.springboot.testautomation.webframework.webdriver;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import com.spring.springboot.testautomation.webframework.annotations.WebDriverScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("!remote")
@ConditionalOnProperty(name = "web.executionType", havingValue = "local")
@LazyConfiguration
public class BrowserDriverConfig {

    @WebDriverScope
    @ConditionalOnProperty(name = "web.browserType", havingValue = "firefox")
    @Primary
    public WebDriver getFirefoxWebDriver(FirefoxOptions firefoxOptions) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    @WebDriverScope
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "web.browserType", havingValue = "chrome")
    @Primary
    public WebDriver getChromeWebDriver(ChromeOptions chromeOptions) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

}
