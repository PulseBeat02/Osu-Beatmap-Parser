package com.github.pulsebeat02.parse.structure.hittable;

public class Hittable extends AbstractHittable {

    private final String name;
    private final boolean parameters;

    public Hittable(final String name, final boolean parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    boolean hasParameters() {
        return parameters;
    }

}
