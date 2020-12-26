package com.github.pulsebeat02.parse.component;

public class DoubleValueLimit {

    private final double lower;
    private final double higher;
    private final double value;

    public DoubleValueLimit(final double lower, final double higher, final int value) {
        this.lower = lower;
        this.higher = higher;
        this.value = value;
    }

    private double getLower() {
        return lower;
    }

    private double getHigher() {
        return higher;
    }

    private double getValue() {
        return value;
    }

}
