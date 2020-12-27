package com.github.pulsebeat02.reflect;

import com.github.pulsebeat02.parse.component.DoubleValueLimit;
import com.github.pulsebeat02.parse.component.IntegerValueLimit;
import com.github.pulsebeat02.parse.component.StringLimit;

import java.util.Arrays;
import java.util.HashSet;

public class ReflectionUtilities {

    private static boolean DEFAULT_BOOLEAN;
    private static byte DEFAULT_BYTE;
    private static short DEFAULT_SHORT;
    private static int DEFAULT_INT;
    private static long DEFAULT_LONG;
    private static float DEFAULT_FLOAT;
    private static double DEFAULT_DOUBLE;
    private static DoubleValueLimit DEFAULT_DOUBLE_VALUE_LIMIT = new DoubleValueLimit(0, 10, 1);
    private static IntegerValueLimit DEFAULT_INTEGER_VALUE_LIMIT = new IntegerValueLimit(new HashSet<>(Arrays.asList(0, 1, 2, 3)), 0);
    private static StringLimit DEFAULT_STRING_LIMIT = new StringLimit(new HashSet<>(Arrays.asList("error")), "");

    public static Object getDefaultValue(final Class<?> clazz) {
        if (clazz.equals(boolean.class) || clazz.equals(Boolean.class)) {
            return DEFAULT_BOOLEAN;
        } else if (clazz.equals(byte.class) || clazz.equals(Byte.class)) {
            return DEFAULT_BYTE;
        } else if (clazz.equals(short.class) || clazz.equals(Short.class)) {
            return DEFAULT_SHORT;
        } else if (clazz.equals(int.class) || clazz.equals(Integer.class)) {
            return DEFAULT_INT;
        } else if (clazz.equals(long.class) || clazz.equals(Long.class)) {
            return DEFAULT_LONG;
        } else if (clazz.equals(float.class) || clazz.equals(Float.class)) {
            return DEFAULT_FLOAT;
        } else if (clazz.equals(double.class) || clazz.equals(Double.class)) {
            return DEFAULT_DOUBLE;
        } else if (clazz.equals(IntegerValueLimit.class)) {
            return DEFAULT_INTEGER_VALUE_LIMIT;
        } else if (clazz.equals(DoubleValueLimit.class)) {
            return DEFAULT_DOUBLE_VALUE_LIMIT;
        } else if (clazz.equals(StringLimit.class)) {
            return DEFAULT_STRING_LIMIT;
        } else if (clazz.isEnum()) {
            return clazz;
        }
        throw new IllegalArgumentException("Class type " + clazz + " not supported");
    }

    public static Object convertToObject(Class<?> clazz, String value) {
        if (Boolean.class == clazz) return Boolean.parseBoolean(value);
        if (Byte.class == clazz) return Byte.parseByte(value);
        if (Short.class == clazz) return Short.parseShort(value);
        if (Integer.class == clazz) return Integer.parseInt(value);
        if (Long.class == clazz) return Long.parseLong(value);
        if (Float.class == clazz) return Float.parseFloat(value);
        if (Double.class == clazz) return Double.parseDouble(value);
        return value;
    }

}
