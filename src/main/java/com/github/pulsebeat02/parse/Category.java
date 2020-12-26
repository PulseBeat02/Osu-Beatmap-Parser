package com.github.pulsebeat02.parse;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Category extends AbstractCategory {

    private final String name;
    private final Set<OsuKey> keys;

    public Category(final String name, final Set<OsuKey> keys) {
        this.name = name;
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

}
