package com.spring.springboot.testautomation.webframework.reporting;

import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@LazyConfiguration
public class AllureLifecycleConfig {

    @Bean
    public AllureLifecycle allure() {
        return Allure.getLifecycle();
    }

}
