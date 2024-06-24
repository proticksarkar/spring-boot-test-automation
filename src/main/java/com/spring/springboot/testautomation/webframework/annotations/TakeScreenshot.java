package com.spring.springboot.testautomation.webframework.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TakeScreenshot {
}
