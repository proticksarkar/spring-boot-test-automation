package com.spring.springboot.testautomation.webframework.webdriver.scope;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class WebDriverScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new WebDriverScopePostProcessor();
    }

}
