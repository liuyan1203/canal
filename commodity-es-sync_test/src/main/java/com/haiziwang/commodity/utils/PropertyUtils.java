package com.haiziwang.commodity.utils;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

public final class PropertyUtils implements Serializable {
    private static Properties property = new Properties();

    static {
        try (
                InputStream in = PropertyUtils.class.getResourceAsStream("/client.properties");
        ) {
            property.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return property.getProperty(key);
    }

    public static Integer getInteger(String key) {
        String value = get(key);
        return null == value ? null : Integer.valueOf(value);
    }

    public static Boolean getBoolean(String key) {
        String value = get(key);
        return null == value ? null : Boolean.valueOf(value);
    }


}
