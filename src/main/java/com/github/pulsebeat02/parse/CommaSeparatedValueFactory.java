package com.github.pulsebeat02.parse;

import com.github.pulsebeat02.file.OsuFile;
import com.github.pulsebeat02.reflect.ReflectionUtilities;
import com.github.pulsebeat02.throwable.BeatmapParseException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommaSeparatedValueFactory extends AbstractCategory {

    private final String name;
    private final OsuFile file;
    private final List<String> contents;
    private final Field[] fields;

    public CommaSeparatedValueFactory(final String name, final OsuFile file, final Class<?> clazz) throws IOException {
        this.name = name;
        this.file = file;
        this.contents = Files.readAllLines(file.getFile().toPath());
        this.fields = clazz.getFields();
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    List<String> getKeyNames() {
        return Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
    }

    @Override
    Map<String, Object> getDefaultValues() {
        return Arrays.stream(fields).collect(Collectors.toMap(Field::getName, field -> ReflectionUtilities.getDefaultValue(field.getClass())));
    }

    @Override
    Map<String, Class<?>> getValueTypes() {
        return Arrays.stream(fields).collect(Collectors.toMap(Field::getName, Field::getClass));
    }

    @Override
    OsuFile getOsuFile() {
        return file;
    }

    @Override
    protected List<String> getOsuFileContents() {
        return contents;
    }

    public void parse() {
        throw new BeatmapParseException("Cannot parse using CommaSeparatedValueFactory");
    }

}
