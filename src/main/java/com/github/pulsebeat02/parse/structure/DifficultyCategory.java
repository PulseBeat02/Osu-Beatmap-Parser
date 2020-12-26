package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.parse.ConfigurationFactory;
import com.github.pulsebeat02.parse.component.DoubleValueLimit;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DifficultyCategory extends ConfigurationFactory {

    public DifficultyCategory() {
        super("Difficulty", Arrays.stream(DifficultyCategoryKey.values()).map(DifficultyCategoryKey::getOsuKey).collect(Collectors.toSet()));
    }

    private enum DifficultyCategoryKey {

        HP_DRAIN_RATE(new OsuKey("HPDrainRate", new DoubleValueLimit(0, 10, 1), DoubleValueLimit.class)),
        CIRCLE_SIZE(new OsuKey("CircleSize", new DoubleValueLimit(0, 10, 1), DoubleValueLimit.class)),
        OVERALL_DIFFICULTY(new OsuKey("OverallDifficulty", new DoubleValueLimit(0, 10, 1), DoubleValueLimit.class)),
        APPROACH_RATE(new OsuKey("ApproachRate", new DoubleValueLimit(0, 10, 1), DoubleValueLimit.class)),
        SLIDER_MULTIPLIER(new OsuKey("SliderMultiplier", new DoubleValueLimit(0, 10, 1), DoubleValueLimit.class)),
        SLIDER_TICK_RATE(new OsuKey("SliderTickRate", new DoubleValueLimit(0, 10, 1), DoubleValueLimit.class));

        private final OsuKey key;

        DifficultyCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() {
            return key;
        }

    }

}
