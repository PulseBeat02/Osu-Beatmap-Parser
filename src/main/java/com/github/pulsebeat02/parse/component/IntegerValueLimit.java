package com.github.pulsebeat02.parse.component;

import java.util.Set;

public class IntegerValueLimit {

    private final Set<Integer> valid;
    private final int value;

    public IntegerValueLimit(final Set<Integer> valid, final int value) {
        this.valid = valid;
        this.value = value;
    }

    private Set<Integer> getValid() { return valid; };

    private int getValue() { return value; }

}
