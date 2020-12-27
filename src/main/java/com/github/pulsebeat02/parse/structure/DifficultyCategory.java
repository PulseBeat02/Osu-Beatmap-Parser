package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.KeyMapFactory;
import com.github.pulsebeat02.parse.component.DoubleValueLimit;
import com.github.pulsebeat02.parse.component.OsuKey;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DifficultyCategory extends KeyMapFactory {

    public DifficultyCategory(final OsuFile file) throws IOException {
        super("Difficulty", file, Arrays.stream(DifficultyCategoryKey.values()).map(DifficultyCategoryKey::getOsuKey).collect(Collectors.toSet()));
    }

    private enum DifficultyCategoryKey {

        HP_DRAIN_RATE(new OsuKey("HPDrainRate", new DoubleValueLimit(0, 10, 1), Double.class)),
        CIRCLE_SIZE(new OsuKey("CircleSize", new DoubleValueLimit(0, 10, 1), Double.class)),
        OVERALL_DIFFICULTY(new OsuKey("OverallDifficulty", new DoubleValueLimit(0, 10, 1), Double.class)),
        APPROACH_RATE(new OsuKey("ApproachRate", new DoubleValueLimit(0, 10, 1), Double.class)),
        SLIDER_MULTIPLIER(new OsuKey("SliderMultiplier", new DoubleValueLimit(0, 10, 1), Double.class)),
        SLIDER_TICK_RATE(new OsuKey("SliderTickRate", new DoubleValueLimit(0, 10, 1), Double.class));

        private final OsuKey key;

        DifficultyCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() {
            return key;
        }

    }

}
