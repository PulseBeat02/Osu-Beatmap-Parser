package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;

import java.io.IOException;
import java.util.List;

public class BreaksCategory extends CommaSeparatedValueFactory {

    private final List<Break> breaks;

    public BreaksCategory(final OsuFile file, final List<Break> breaks) throws IOException {
        super("Breaks", file, BreaksCategory.class);
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
