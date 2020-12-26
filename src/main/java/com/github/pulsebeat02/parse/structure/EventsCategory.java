package com.github.pulsebeat02.parse.structure;

import java.util.List;

public class EventsCategory {

    private final List<OsuEvent> events;

    public EventsCategory(final List<OsuEvent> events) {
        this.events = events;
    }

    public List<OsuEvent> getEvents() {
        return events;
    }

    private class OsuEvent {

        private final String eventType;
        private final int startTime;
        private final List<String> eventParams;

        public OsuEvent(final String type, final int start, final List<String> params) {
            this.eventType = type;
            this.startTime = start;
            this.eventParams = params;
        }

        public String getEventType() {
            return eventType;
        }

        public int getStartTime() {
            return startTime;
        }

        public List<String> getEventParams() {
            return eventParams;
        }

    }

}
