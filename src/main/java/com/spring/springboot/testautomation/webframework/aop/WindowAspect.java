package com.spring.springboot.testautomation.webframework.aop;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import com.spring.springboot.testautomation.webframework.annotations.SwitchWindow;
import com.spring.springboot.testautomation.webframework.utils.WindowUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@LazyComponent
public class WindowAspect {

    @LazyAutowired
    private WindowUtil windowSwitchUtil;

    @Before("@target(switchWindow) && within(com.spring.springboot.testautomation..*)")
    public void before(SwitchWindow switchWindow) {
        this.windowSwitchUtil.switchByTitle(switchWindow.value());
    }

    @After("@target(switchWindow) && within(com.spring.springboot.testautomation..*)")
    public void after(SwitchWindow switchWindow) {
        this.windowSwitchUtil.switchByIndex(0);
    }

}
