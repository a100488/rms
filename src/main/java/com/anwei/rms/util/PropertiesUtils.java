package com.anwei.rms.util;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public final class PropertiesUtils {

    private static final ConcurrentHashMap<String, Properties> propertiesHolder
        = new ConcurrentHashMap<String, Properties>();

    private PropertiesUtils() {}

    public static Properties getProperties(String resourceName) {

        if (StringUtils.isEmpty(resourceName)) {
            return new Properties();
        }

        if (PropertiesUtils.propertiesHolder.containsKey(resourceName)) {
            return PropertiesUtils.propertiesHolder.get(resourceName);
        }

        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties(resourceName);
        } catch (IOException ioe) {
            properties = new Properties();
        }
        if (!properties.isEmpty()) {
            PropertiesUtils.propertiesHolder.put(resourceName, properties);
        }
        return properties;
    }

    public static String getProperty(String resourceName, String key) {

        Properties properties = PropertiesUtils.getProperties(resourceName);
        return properties.getProperty(key);
    }
}
