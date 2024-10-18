package com.java.api.config;

import com.java.api.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigReader {
    private static final Properties properties = new Properties();
    private static final HashMap<String, String> MAP = new HashMap<>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.CONFIG_PROPERTIES_PATH);
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.exit(0);
        }
        properties.forEach((key, value) -> MAP.put(String.valueOf(key), (String.valueOf(value))));
    }

    public static String getValue(String Key) {
        return MAP.get(Key);

    }
}
