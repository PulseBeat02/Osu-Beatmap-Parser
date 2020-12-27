package com.github.pulsebeat02.throwable;

public class CorruptedBeatmapException extends AssertionError {

    public CorruptedBeatmapException(final String exception) {
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
