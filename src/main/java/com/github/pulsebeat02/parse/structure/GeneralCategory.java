package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.KeyMapFactory;
import com.github.pulsebeat02.parse.component.IntegerValueLimit;
import com.github.pulsebeat02.parse.component.OsuKey;
import com.github.pulsebeat02.parse.component.StringLimit;
import com.github.pulsebeat02.reflect.ReflectionUtilities;
import com.github.pulsebeat02.throwable.KeyNotFoundException;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneralCategory extends KeyMapFactory {

    private Map<GeneralCategoryKey, Object> values;

    public GeneralCategory(final OsuFile file) throws IOException {
        super("General", file, Arrays.stream(GeneralCategoryKey.values()).map(GeneralCategoryKey::getOsuKey).collect(Collectors.toSet()));
        this.values = new EnumMap<>(GeneralCategoryKey.class);
        for (GeneralCategoryKey key : GeneralCategoryKey.values()) {
            values.put(key, key.getOsuKey().getDefaultValue());
        }
    }

    private enum GeneralCategoryKey {

        AUDIO_FILE_NAME(new OsuKey("AudioFilename", "", String.class)),
        AUDIO_LEAD_IN(new OsuKey("AudioLeadIn", 0, Integer.class)),
        AUDIO_HASH(new OsuKey("AudioHash", "", String.class)),
        PREVIEW_TIME(new OsuKey("PreviewTime", -1, Integer.class)),
        COUNTDOWN(new OsuKey("Countdown", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1, 2, 3)), 1), Integer.class)),
        SAMPLE_SET(new OsuKey("SampleSet", new StringLimit(new HashSet<>(Arrays.asList("Normal", "Soft", "Drum")), "Normal"), String.class)),
        STACK_LENIENCY(new OsuKey("StackLeniency", 0.7, Double.class)),
        MODE(new OsuKey("Mode", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1, 2, 3)), 0), IntegerValueLimit.class)),
        LETTERBOX_IN_BREAKS(new OsuKey("LetterboxInBreaks", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class)),
        STORY_FIRE_IN_FRONT(new OsuKey("StoryFireInFront", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 1), Integer.class)),
        USE_SKIN_SPRITES(new OsuKey("UseSkinSprites", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class)),
        ALWAYS_SHOW_PLAY_FIELD(new OsuKey("AlwaysShowPlayfield", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class)),
        OVERLAY_POSITION(new OsuKey("OverlayPosition", new StringLimit(new HashSet<>(Arrays.asList("NoChange", "Below", "Above")), "NoChange"), Integer.class)),
        SKIN_PREFERENCE(new OsuKey("SkinPreference", "", String.class)),
        EPILEPSY_WARNING(new OsuKey("EpilepsyWarning", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class)),
        COUNTDOWN_OFFSET(new OsuKey("CountdownOffset", 0, Integer.class)),
        SPECIAL_STYLE(new OsuKey("SpecialStyle", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class)),
        WIDESCREEN_STORYBOARD(new OsuKey("WidescreenStoryboard", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class)),
        SAMPLES_MATCH_PLAYBACK_RATE(new OsuKey("SamplesMatchPlaybackRate", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), Integer.class));

        private final OsuKey key;

        GeneralCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() {
            return key;
        }

        public static GeneralCategoryKey getKeyFromString(final String name) {
            for (GeneralCategoryKey key : GeneralCategoryKey.values()) {
                if (key.getOsuKey().getName().equals(name)) {
                    return key;
                }
            }
            throw new KeyNotFoundException("Key: " + name + " could not be found!");
        }

    }

    private Object getValue(GeneralCategoryKey key) {
        return values.get(key);
    }

    private String getAudioFileName() {
        return (String) values.get(GeneralCategoryKey.AUDIO_FILE_NAME);
    }

    private int getAudioLeadIn() {
        return (int) values.get(GeneralCategoryKey.AUDIO_LEAD_IN);
    }

    private String getAudioHash() {
        return (String) values.get(GeneralCategoryKey.AUDIO_HASH);
    }

    private int getPreviewTime() {
        return (int) values.get(GeneralCategoryKey.PREVIEW_TIME);
    }

    private int getCountDown() {
        return (int) values.get(GeneralCategoryKey.COUNTDOWN);
    }

    private String getSampleSet() {
        return (String) values.get(GeneralCategoryKey.SAMPLE_SET);
    }

    private double getStackLeniency() {
        return (double) values.get(GeneralCategoryKey.STACK_LENIENCY);
    }

    private int getMode() {
        return (int) values.get(GeneralCategoryKey.MODE);
    }

    private int getLetterboxInBreaks() {
        return (int) values.get(GeneralCategoryKey.LETTERBOX_IN_BREAKS);
    }

    private int getStoryFireInFront() {
        return (int) values.get(GeneralCategoryKey.STORY_FIRE_IN_FRONT);
    }

    private int getUseSkinSprites() {
        return (int) values.get(GeneralCategoryKey.USE_SKIN_SPRITES);
    }

    private int getAlwaysShowPlayField() {
        return (int) values.get(GeneralCategoryKey.ALWAYS_SHOW_PLAY_FIELD);
    }

    private String getOverlayPosition() {
        return (String) values.get(GeneralCategoryKey.OVERLAY_POSITION);
    }

    private String getSkinPreference() {
        return (String) values.get(GeneralCategoryKey.SKIN_PREFERENCE);
    }

    private int getEpilepsyWarning() {
        return (int) values.get(GeneralCategoryKey.EPILEPSY_WARNING);
    }

    private int getCountdownOffset() {
        return (int) values.get(GeneralCategoryKey.COUNTDOWN_OFFSET);
    }

    private int getSpecialStyle() {
        return (int) values.get(GeneralCategoryKey.SPECIAL_STYLE);
    }

    private int getWidescreenStoryboard() {
        return (int) values.get(GeneralCategoryKey.WIDESCREEN_STORYBOARD);
    }

    private int getSamplesMatchPlaybackRate() {
        return (int) values.get(GeneralCategoryKey.SAMPLES_MATCH_PLAYBACK_RATE);
    }

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        boolean read = false;
        for (String line : contents) {
            if (line.equals("[General]")) {
                read = true;
                continue;
            } else if (line.equals("[Editor]")) {
                break;
            }
            if (read) {
                String[] split = line.split(":");
                String key = split[0].trim();
                String value = split[1].trim();
                GeneralCategoryKey categoryKey = GeneralCategoryKey.getKeyFromString(key);
                try {
                    values.put(categoryKey, ReflectionUtilities.convertToObject(categoryKey.getOsuKey().getDefaultValueType(), value));
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                    throw new KeyNotFoundException("Key could not be found for: ");
                }
            }
        }
    }

}
