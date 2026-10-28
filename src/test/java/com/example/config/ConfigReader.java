package com.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) throw new IllegalStateException("config.properties was not found on the classpath");
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConfigReader() {}
    public static String get(String key) { return PROPERTIES.getProperty(key); }
    public static int getInt(String key) { return Integer.parseInt(get(key)); }
    public static boolean getBoolean(String key) { return Boolean.parseBoolean(get(key)); }
}
