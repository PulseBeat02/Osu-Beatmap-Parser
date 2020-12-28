package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.KeyMapFactory;
import com.github.pulsebeat02.parse.component.DoubleValueLimit;
import com.github.pulsebeat02.parse.component.OsuKey;
import com.github.pulsebeat02.reflect.ReflectionUtilities;
import com.github.pulsebeat02.throwable.KeyNotFoundException;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DifficultyCategory extends KeyMapFactory {

    private final Map<DifficultyCategoryKey, Object> values;

    public DifficultyCategory(final OsuFile file) throws IOException {
        super("Difficulty", file, Arrays.stream(DifficultyCategoryKey.values()).map(DifficultyCategoryKey::getOsuKey).collect(Collectors.toSet()));
        this.values = new EnumMap<>(DifficultyCategoryKey.class);
        for (DifficultyCategoryKey key : DifficultyCategoryKey.values()) {
            values.put(key, key.getOsuKey().getDefaultValue());
        }
    }

    @Deprecated
    private Object getValue(DifficultyCategoryKey key) {
        return values.get(key);
    }

    private double getHpDrainRate() {
        return (double) values.get(DifficultyCategoryKey.HP_DRAIN_RATE);
    }

    private double getCircleSize() {
        return (double) values.get(DifficultyCategoryKey.CIRCLE_SIZE);
    }

    private double getOverallDifficulty() {
        return (double) values.get(DifficultyCategoryKey.OVERALL_DIFFICULTY);
    }

    private double getApproachRate() {
        return (double) values.get(DifficultyCategoryKey.APPROACH_RATE);
    }

    private double getSliderMultiplier() {
        return (double) values.get(DifficultyCategoryKey.SLIDER_MULTIPLIER);
    }

    private double getSliderTickRate() {
        return (double) values.get(DifficultyCategoryKey.SLIDER_TICK_RATE);
    }

    private enum DifficultyCategoryKey {

        HP_DRAIN_RATE(new OsuKey("HPDrainRate", new DoubleValueLimit(0, 10, 1), Double.class)),
        CIRCLE_SIZE(new OsuKey("CircleSize", new DoubleValueLimit(0, 10, 1), Double.class)),
        OVERALL_DIFFICULTY(new OsuKey("OverallDifficulty", new DoubleValueLimit(0, 10, 1), Double.class)),
        APPROACH_RATE(new OsuKey("ApproachRate", new DoubleValueLimit(0, 10, 1), Double.class)),
        SLIDER_MULTIPLIER(new OsuKey("SliderMultiplier", new DoubleValueLimit(0, 10, 1), Double.class)),
        SLIDER_TICK_RATE(new OsuKey("SliderTickRate", new DoubleValueLimit(0, 10, 1), Double.class));

        private static final Map<String, DifficultyCategoryKey> keys = new HashMap<>();

        static {
            for (DifficultyCategoryKey key : DifficultyCategoryKey.values()) {
                keys.put(key.getOsuKey().getName(), key);
            }
        }

        private final OsuKey key;

        DifficultyCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() {
            return key;
        }

        public static DifficultyCategoryKey getKeyFromString(final String name) {
            return keys.get(name);
        }

    }

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        boolean read = false;
        for (String line : contents) {
            if (line.equals("[Difficulty]")) {
                read = true;
                continue;
            } else if (line.startsWith("[")) {
                break;
            }
            if (read) {
                String[] split = line.split(":");
                String key = split[0].trim();
                String value = split[1].trim();
                DifficultyCategoryKey categoryKey = DifficultyCategoryKey.getKeyFromString(key);
                try {
                    values.put(categoryKey, ReflectionUtilities.convertToObject(categoryKey.getOsuKey().getDefaultValueType(), value));
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                    throw new KeyNotFoundException("Key could not be found for: " + key);
                }
            }
        }
    }

}
