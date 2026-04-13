package com.guardian.framework.config;

import java.util.Properties;
import java.io.FileInputStream;

public class ConfigManager {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}