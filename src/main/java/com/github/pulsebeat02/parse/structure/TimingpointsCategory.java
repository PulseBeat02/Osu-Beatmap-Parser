package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.parse.component.IntegerValueLimit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TimingpointsCategory {

    private final List<Timingpoint> points;

    public TimingpointsCategory(List<Timingpoint> points) {
        this.points = points;
    }

    public List<Timingpoint> getPoints() {
        return points;
    }

    private class Timingpoint {

        private final int time;
        private final double beatLength;
        private final int meter;
        private final int sampleSet;
        private final int sampleIndex;
        private final int volume;
        private final IntegerValueLimit unherited;
        private final int effects;

        public Timingpoint(final int time, final double beatLength, final int meter,
                           final int sampleSet, final int sampleIndex, final int volume,
                           final int unherited, final int effects) {
            this.time = time;
            this.beatLength = beatLength;
            this.meter = meter;
            this.sampleSet = sampleSet;
            this.sampleIndex = sampleIndex;
            this.volume = volume;
            this.unherited = new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), unherited);
            this.effects = effects;
        }

        public int getTime() {
            return time;
        }

        public double getBeatLength() {
            return beatLength;
        }

        public int getMeter() {
            return meter;
        }

        public int getSampleSet() {
            return sampleSet;
        }

        public int getSampleIndex() {
            return sampleIndex;
        }

        public int getVolume() {
            return volume;
        }

        public IntegerValueLimit getUnherited() {
            return unherited;
        }

        public int getEffects() {
            return effects;
        }

    }

}
