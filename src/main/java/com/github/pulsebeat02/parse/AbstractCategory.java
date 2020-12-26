package com.github.pulsebeat02.parse;

import java.util.List;
import java.util.Map;

/**
 * Class for Abstraction of Categories
 *
 * @author PulseBeat_02
 * @version 1.0.0
 * @since 2020-12-26
 */
public abstract class AbstractCategory {

    /**
     * Returns the name of the category. (For map purposes)
     *
     * @return String name of the category.
     */
    abstract String getName();

    /**
     * Returns the key names of the category. (For map purposes)
     *
     * @return List<String> keys of category.
     */
    abstract List<String> getKeyNames();

    /**
     * Returns the default values of the category. (For map purposes)
     *
     * @return Map<String, Object> default values for keys of category.
     */
    abstract Map<String, Object> getDefaultValues();

    /**
     * Returns the default values of the category. (For map purposes)
     *
     * @return Map<String, Class < ?>> types values must be to follow.
     */
    abstract Map<String, Class<?>> getValueTypes();

    public static class OsuKey {

        private final String name;
        private final Object defaultValue;
        private final Class<?> defaultValueType;

        public OsuKey(final String name, final Object defaultValue, final Class<?> defaultValueType) {
            this.name = name;
            this.defaultValue = defaultValue;
            this.defaultValueType = defaultValueType;
        }

        public String getName() {
            return name;
        }

        public Object getDefaultValue() {
            return defaultValue;
        }

        public Class<?> getDefaultValueType() {
            return defaultValueType;
        }

    }
}
