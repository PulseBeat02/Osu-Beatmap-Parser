package com.github.pulsebeat02.parse.component;

public class OsuKey {

    private final String name;
    private final Object defaultValue;
    private final Class<?> defaultValueType;

    public OsuKey(final String name, final Object defaultValue, final Class<?> defaultValueType) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.defaultValueType = defaultValueType;
    }

    public String getName() {
        return name;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Class<?> getDefaultValueType() {
        return defaultValueType;
    }

}