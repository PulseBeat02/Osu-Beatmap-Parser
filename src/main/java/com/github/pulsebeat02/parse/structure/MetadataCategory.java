package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.KeyMapFactory;
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

public class MetadataCategory extends KeyMapFactory {

    private final Map<MetadataCategoryKey, Object> values;

    public MetadataCategory(final OsuFile file) throws IOException {
        super("Metadata", file, Arrays.stream(MetadataCategoryKey.values()).map(MetadataCategoryKey::getOsuKey).collect(Collectors.toSet()));
        this.values = new EnumMap<>(MetadataCategoryKey.class);
        for (MetadataCategoryKey key : MetadataCategoryKey.values()) {
            values.put(key, key.getOsuKey().getDefaultValue());
        }
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

        private static final Map<String, MetadataCategoryKey> keys = new HashMap<>();

        static {
            for (MetadataCategoryKey key : MetadataCategoryKey.values()) {
                keys.put(key.getOsuKey().getName(), key);
            }
        }

        private final OsuKey key;

        MetadataCategoryKey(final OsuKey key) {
            this.key = key;
        }

        public OsuKey getOsuKey() {
            return key;
        }

        public static MetadataCategoryKey getKeyFromString(final String name) {
            return keys.get(name);
        }

    }

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        boolean read = false;
        for (String line : contents) {
            if (line.equals("[Metadata]")) {
                read = true;
                continue;
            } else if (line.startsWith("[")) {
                break;
            }
            if (read) {
                String[] split = line.split(":");
                String key = split[0].trim();
                String value = split[1].trim();
                MetadataCategoryKey categoryKey = MetadataCategoryKey.getKeyFromString(key);
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
