package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.parse.ConfigurationFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MetadataCategory extends ConfigurationFactory {

    public MetadataCategory() {
        super("Metadata", Arrays.stream(MetadataCategoryKey.values()).map(MetadataCategoryKey::getOsuKey).collect(Collectors.toSet()));
    }

    private enum MetadataCategoryKey {

        TITLE(new OsuKey("Title", "", String.class)),
        TITLE_UNICODE(new OsuKey("TitleUnicode", "", String.class)),
        ARTIST(new OsuKey("Artist", "", String.class)),
        ARTIST_UNICODE(new OsuKey("ArtistUnicode", "", String.class)),
        CREATOR(new OsuKey("Creator", "", String.class)),
        VERSION(new OsuKey("Version", "", String.class)),
        SOURCE(new OsuKey("Source", "", String.class)),
        TAGS(new OsuKey("Tags", "", String.class)),
        BEATMAP_ID(new OsuKey("BeatmapID", "", String.class)),
        BEATMAP_SET_ID(new OsuKey("BeatmapSetID", "", String.class));

        private final OsuKey key;

        MetadataCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() {
            return key;
        }

    }

}
