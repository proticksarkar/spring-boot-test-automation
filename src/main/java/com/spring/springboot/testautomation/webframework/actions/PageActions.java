package com.spring.springboot.testautomation.webframework.actions;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import org.springframework.beans.factory.annotation.Autowired;

@LazyComponent
public class PageActions {

    @Autowired
    public AlertActions alertActions;
    @Autowired
    public ElementActions elementActions;
    @Autowired
    public JavascriptActions javascriptActions;
    @Autowired
    public NavigationActions navigationActions;
    @Autowired
    public WaitActions waitActions;

}
