package com.github.pulsebeat02.parse.structure.hittable;

public class Hold extends Hittable {

    private final int endTime;

    public Hold(final int endTime) {
        super("Hold", true);
        this.endTime = endTime;
    }

    public int getEndTime() {
        return endTime;
    }

}
