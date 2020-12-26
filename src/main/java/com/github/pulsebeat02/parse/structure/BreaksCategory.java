package com.github.pulsebeat02.parse.structure;

import java.util.List;

public class BreaksCategory {

    private final List<Break> breaks;

    public BreaksCategory(final List<Break> breaks) {
        this.breaks = breaks;
    }

    private class Break {

        private final int startTime;
        private final int endTime;

        public Break(final int startTime, final int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

    }

}
