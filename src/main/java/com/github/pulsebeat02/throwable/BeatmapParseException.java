package com.github.pulsebeat02.throwable;

public class BeatmapParseException extends AssertionError {

    public BeatmapParseException(final String exception) {
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
