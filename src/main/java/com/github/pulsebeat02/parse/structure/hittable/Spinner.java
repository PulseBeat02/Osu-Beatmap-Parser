package com.github.pulsebeat02.parse.structure.hittable;

public class Spinner extends Hittable {

    private final int endTime;

    public Spinner(final int endTime) {
        super("Spinner", true);
        this.endTime = endTime;
    }

    public int getEndTime() {
        return endTime;
    }

}
