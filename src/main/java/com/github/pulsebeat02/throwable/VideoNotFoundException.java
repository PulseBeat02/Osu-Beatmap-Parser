package com.github.pulsebeat02.throwable;

public class VideoNotFoundException extends AssertionError {

    public VideoNotFoundException(String exception) {
        super(exception);
    }

    @Override
    public synchronized Throwable getCause() {
        return this;
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return this;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
