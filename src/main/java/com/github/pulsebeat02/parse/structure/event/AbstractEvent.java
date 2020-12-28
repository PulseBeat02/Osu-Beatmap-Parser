package com.github.pulsebeat02.parse.structure.event;

import java.util.List;

abstract public class AbstractEvent {

    abstract String getName();

    abstract int getStartTime();

    abstract List<String> getEventParams();

}
