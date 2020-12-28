package com.github.pulsebeat02.parse.structure;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.CommaSeparatedValueFactory;
import com.github.pulsebeat02.parse.structure.event.OsuEvent;
import com.github.pulsebeat02.reflect.ReflectionUtilities;
import com.github.pulsebeat02.throwable.CorruptedBeatmapException;
import com.github.pulsebeat02.throwable.KeyNotFoundException;

import java.io.IOException;
import java.util.List;

public class EventsCategory extends CommaSeparatedValueFactory {

    private final List<OsuEvent> events;

    public EventsCategory(final OsuFile file, final List<OsuEvent> events) throws IOException {
        super("Events", file, EventsCategory.class);
        this.events = events;
    }

    public List<OsuEvent> getEvents() {
        return events;
    }

    @Override
    public void parse() {
        List<String> contents = getOsuFileContents();
        boolean read = false;
        for (String line : contents) {
            if (line.equals("[Events]")) {
                read = true;
                continue;
            } else if (line.startsWith("[")) {
                break;
            }
            if (read) {
                String[] split = line.split(":");
                String key = split[0].trim();
                String value = split[1].trim();
                MetadataCategory.MetadataCategoryKey categoryKey = MetadataCategory.MetadataCategoryKey.getKeyFromString(key);
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
