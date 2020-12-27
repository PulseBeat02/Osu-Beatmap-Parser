package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;

import java.io.IOException;
import java.util.List;

public class EventsCategory extends CommaSeparatedValueFactory {

    private final List<OsuEvent> events;

    public EventsCategory(final OsuFile file, final List<OsuEvent> events) throws IOException {
        super("Events", file, EventsCategory.class);
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
