package com.github.pulsebeat02.file;

import com.github.pulsebeat02.parse.structure.BackgroundsCategory;
import com.github.pulsebeat02.parse.structure.BreaksCategory;
import com.github.pulsebeat02.parse.structure.ColoursCategory;
import com.github.pulsebeat02.parse.structure.DifficultyCategory;
import com.github.pulsebeat02.parse.structure.EventsCategory;
import com.github.pulsebeat02.parse.structure.GeneralCategory;
import com.github.pulsebeat02.parse.structure.MetadataCategory;
import com.github.pulsebeat02.parse.structure.StoryboardsCategory;
import com.github.pulsebeat02.parse.structure.TimingpointsCategory;
import com.github.pulsebeat02.parse.structure.VideosCategory;

public class OsuFile {

    private final OszFile parent;
    private final BackgroundsCategory backgrounds;
    private final BreaksCategory breaks;
    private final ColoursCategory colours;
    private final DifficultyCategory difficulties;
    private final EventsCategory events;
    private final GeneralCategory general;
    private final MetadataCategory metadataCategory;
    private final StoryboardsCategory boards;
    private final TimingpointsCategory timings;
    private final VideosCategory videos;

    public OsuFile(final OszFile parent,
                   final BackgroundsCategory backgrounds,
                   final BreaksCategory breaks,
                   final ColoursCategory colours,
                   final DifficultyCategory difficulties,
                   final EventsCategory events,
                   final GeneralCategory general,
                   final MetadataCategory metadataCategory,
                   final StoryboardsCategory boards,
                   final TimingpointsCategory timings,
                   final VideosCategory videos) {
        this.parent = parent;
        this.backgrounds = backgrounds;
        this.breaks = breaks;
        this.colours = colours;
        this.difficulties = difficulties;
        this.events = events;
        this.general = general;
        this.metadataCategory = metadataCategory;
        this.boards = boards;
        this.timings = timings;
        this.videos = videos;
    }

    public OszFile getParent() {
        return parent;
    }

    public BackgroundsCategory getBackgrounds() {
        return backgrounds;
    }

    public BreaksCategory getBreaks() {
        return breaks;
    }

    public ColoursCategory getColours() {
        return colours;
    }

    public DifficultyCategory getDifficulties() {
        return difficulties;
    }

    public EventsCategory getEvents() {
        return events;
    }

    public GeneralCategory getGeneral() {
        return general;
    }

    public MetadataCategory getMetadataCategory() {
        return metadataCategory;
    }

    public StoryboardsCategory getBoards() {
        return boards;
    }

    public TimingpointsCategory getTimings() {
        return timings;
    }

    public VideosCategory getVideos() {
        return videos;
    }

    public static class OsuFileBuilder {

        private OszFile parent;
        private BackgroundsCategory backgrounds;
        private BreaksCategory breaks;
        private ColoursCategory colours;
        private DifficultyCategory difficulties;
        private EventsCategory events;
        private GeneralCategory general;
        private MetadataCategory metadataCategory;
        private StoryboardsCategory boards;
        private TimingpointsCategory timings;
        private VideosCategory videos;

        public OsuFileBuilder setParent(final OszFile parent) {
            this.parent = parent;
            return this;
        }

        public OsuFileBuilder setBackgrounds(final BackgroundsCategory backgrounds) {
            this.backgrounds = backgrounds;
            return this;
        }

        public OsuFileBuilder setBreaks(final BreaksCategory breaks) {
            this.breaks = breaks;
            return this;
        }

        public OsuFileBuilder setColours(final ColoursCategory colours) {
            this.colours = colours;
            return this;
        }

        public OsuFileBuilder setDifficulties(final DifficultyCategory difficulties) {
            this.difficulties = difficulties;
            return this;
        }

        public OsuFileBuilder setEvents(final EventsCategory events) {
            this.events = events;
            return this;
        }

        public OsuFileBuilder setGeneral(final GeneralCategory general) {
            this.general = general;
            return this;
        }

        public OsuFileBuilder setMetadataCategory(final MetadataCategory metadataCategory) {
            this.metadataCategory = metadataCategory;
            return this;
        }

        public OsuFileBuilder setBoards(final StoryboardsCategory boards) {
            this.boards = boards;
            return this;
        }

        public OsuFileBuilder setTimings(final TimingpointsCategory timings) {
            this.timings = timings;
            return this;
        }

        public OsuFileBuilder setVideos(final VideosCategory videos) {
            this.videos = videos;
            return this;
        }

        public OsuFile createOsuFile() {
            return new OsuFile(parent, backgrounds, breaks, colours, difficulties, events, general, metadataCategory, boards, timings, videos);
        }

    }

}
