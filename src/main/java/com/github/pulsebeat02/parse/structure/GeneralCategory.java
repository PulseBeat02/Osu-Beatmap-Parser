package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.parse.Category;
import com.github.pulsebeat02.parse.component.StringLimit;
import com.github.pulsebeat02.parse.component.IntegerValueLimit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class GeneralCategory extends Category {

    public GeneralCategory() {
        super("General", Arrays.stream(GeneralCategoryKey.values()).map(GeneralCategoryKey::getOsuKey).collect(Collectors.toSet()));
    }

    private enum GeneralCategoryKey {

        AUDIO_FILE_NAME(new OsuKey("AudioFilename", "", String.class)),
        AUDIO_LEAD_IN(new OsuKey("AudioLeadIn", 0, Integer.class)),
        AUDIO_HASH(new OsuKey("AudioHash", "", String.class)),
        PREVIEW_TIME(new OsuKey("PreviewTime", -1, Integer.class)),
        COUNTDOWN(new OsuKey("Countdown", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1, 2, 3)), 1), IntegerValueLimit.class)),
        SAMPLE_SET(new OsuKey("SampleSet", new StringLimit(new HashSet<>(Arrays.asList("Normal", "Soft", "Drum")), "Normal"), StringLimit.class)),
        STACK_LENIENCY(new OsuKey("StackLeniency", 0.7, Double.class)),
        MODE(new OsuKey("Mode", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1, 2, 3)), 0), IntegerValueLimit.class)),
        LETTERBOX_IN_BREAKS(new OsuKey("LetterboxInBreaks", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class)),
        STORY_FIRE_IN_FRONT(new OsuKey("StoryFireInFront", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 1), IntegerValueLimit.class)),
        USE_SKIN_SPRITES(new OsuKey("UseSkinSprites", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class)),
        ALWAYS_SHOW_PLAY_FIELD(new OsuKey("UseSkinSprites", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class)),
        OVERLAY_POSITION(new OsuKey("OverlayPosition", new StringLimit(new HashSet<>(Arrays.asList("NoChange", "Below", "Above")), "NoChange"), IntegerValueLimit.class)),
        SKIN_PREFERENCE(new OsuKey("SkinPreference", "", IntegerValueLimit.class)),
        EPILEPSY_WARNING(new OsuKey("EpilepsyWarning", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class)),
        COUNTDOWN_OFFSET(new OsuKey("CountdownOffset", 0, Integer.class)),
        SPECIAL_STYLE(new OsuKey("SpecialStyle", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class)),
        WIDESCREEN_STORYBOARD(new OsuKey("WidescreenStoryboard", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class)),
        SAMPLES_MATCH_PLAYBACK_RATE(new OsuKey("SamplesMatchPlaybackRate", new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1)), 0), IntegerValueLimit.class));

        private final OsuKey key;

        GeneralCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() { return key; }

    }

}
