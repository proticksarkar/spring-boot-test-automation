package com.spring.springboot.testautomation.webframework.annotations;

import java.lang.annotation.*;

@PageComponent
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SwitchWindow {
    String value() default "";
}
