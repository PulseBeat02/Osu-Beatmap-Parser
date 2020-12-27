package com.github.pulsebeat02.parse;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.parse.component.OsuKey;
import com.github.pulsebeat02.throwable.BeatmapParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class KeyMapFactory extends AbstractCategory {

    private final String name;
    private final OsuFile file;
    private final List<String> contents;
    private final Set<OsuKey> keys;

    public KeyMapFactory(final String name, final OsuFile file, final Set<OsuKey> keys) throws IOException {
        this.name = name;
        this.file = file;
        this.contents = Files.readAllLines(file.getFile().toPath());
        this.keys = keys;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    List<String> getKeyNames() {
        return keys.stream().map(OsuKey::getName).collect(Collectors.toList());
    }

    @Override
    Map<String, Object> getDefaultValues() {
        return keys.stream().collect(Collectors.toMap(OsuKey::getName, OsuKey::getDefaultValue));
    }

    @Override
    Map<String, Class<?>> getValueTypes() {
        return keys.stream().collect(Collectors.toMap(OsuKey::getName, OsuKey::getDefaultValueType));
    }

    @Override
    OsuFile getOsuFile() {
        return file;
    }

    @Override
    protected List<String> getOsuFileContents() {
        return null;
    }

    public void parse() {
        throw new BeatmapParseException("Cannot parse using KeyMapFactory");
    }

}
