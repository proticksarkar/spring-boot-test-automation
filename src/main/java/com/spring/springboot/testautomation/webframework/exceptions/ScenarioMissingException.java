package com.spring.springboot.testautomation.webframework.exceptions;

public class ScenarioMissingException extends RuntimeException {

    public ScenarioMissingException (String exceptionMessage) {
        super(exceptionMessage);
    }

}
