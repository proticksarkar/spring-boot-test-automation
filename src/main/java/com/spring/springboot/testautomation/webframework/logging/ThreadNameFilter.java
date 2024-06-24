package com.spring.springboot.testautomation.webframework.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class ThreadNameFilter extends Filter<ILoggingEvent> {

    private String threadNamePattern;

    public void setThreadNamePattern(String threadNamePattern) {
        this.threadNamePattern = threadNamePattern;
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getThreadName().contains(threadNamePattern)) {
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }

}
