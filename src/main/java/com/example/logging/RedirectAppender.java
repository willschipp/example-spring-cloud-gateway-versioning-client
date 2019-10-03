package com.example.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class RedirectAppender extends AppenderBase<ILoggingEvent> {

    private static final String REDIRECTED = "Redirected from"; //TODO externalize

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (eventObject.getMessage().contains(REDIRECTED)) {
            // TODO do something here with the match for a keyword
        }//end if
    }
}
