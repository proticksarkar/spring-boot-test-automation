package com.spring.springboot.testautomation.webframework.aop;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import com.spring.springboot.testautomation.webframework.annotations.TakeScreenshot;
import com.spring.springboot.testautomation.webframework.utils.ScreenshotUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.io.IOException;

@Aspect
@LazyComponent
public class ScreenshotAspect {

    @LazyAutowired
    private ScreenshotUtil screenshotUtil;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint joinPoint, TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotUtil.takeScreenshot(joinPoint.getSignature().getName());
    }

}
