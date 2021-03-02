package com.haiziwang.commodity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

public final class PropertyUtils implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);
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
        logger.info(">> {} [{}]", key, property.getProperty(key));
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

    public static void main(String[] args) {
        System.out.println(PropertyUtils.get("client.username"));
        System.out.println(PropertyUtils.getInteger("client.batch.size"));
        System.out.println(PropertyUtils.getBoolean("client.debug"));
    }

}
