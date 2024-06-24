package com.spring.springboot.testautomation.annotations;

import com.spring.springboot.testautomation.SpringBootTestAutomationApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = SpringBootTestAutomationApplication.class)
public @interface WebTest {
}
