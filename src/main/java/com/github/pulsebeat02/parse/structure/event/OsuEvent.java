package com.github.pulsebeat02.parse.structure.event;

import java.util.List;

public class OsuEvent extends AbstractEvent {

    private final String name;
    private final int startTime;
    private final List<String> eventParams;

    public OsuEvent(final String name, final int start, final List<String> params) {
        this.name = name;
        this.startTime = start;
        this.eventParams = params;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    public int getStartTime() {
        return startTime;
    }

    @Override
    public List<String> getEventParams() {
        return eventParams;
    }

}
