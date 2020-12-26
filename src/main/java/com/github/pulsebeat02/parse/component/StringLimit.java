package com.github.pulsebeat02.parse.component;

import java.util.Set;

public class StringLimit {

    private final Set<String> valid;
    private final String value;

    public StringLimit(final Set<String> valid, final String value) {
        this.valid = valid;
        this.value = value;
    }

    public Set<String> getValid() { return valid; }

    public String getValue() { return value; }

}
