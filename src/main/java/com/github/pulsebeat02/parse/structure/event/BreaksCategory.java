package com.github.pulsebeat02.parse.structure.event;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;
import com.github.pulsebeat02.throwable.CorruptedBeatmapException;

import java.io.IOException;
import java.util.List;

public class BreaksCategory extends CommaSeparatedValueFactory {

    private final List<Break> breaks;

    public BreaksCategory(final OsuFile file, final List<Break> breaks) throws IOException {
        super("Breaks", file, BreaksCategory.class);
        this.breaks = breaks;
    }

    public List<Break> getBreaks() {
        return breaks;
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

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        for (String line : contents) {
            if (line.startsWith("2")) {
                String[] parse = line.split(",");
                try {
                    int startTime = Integer.parseInt(parse[1]);
                    int endTime = Integer.parseInt(parse[2]);
                    breaks.add(new Break(startTime, endTime));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new CorruptedBeatmapException("Corrupted Beatmap File!");
                }
            }
        }
    }

}
