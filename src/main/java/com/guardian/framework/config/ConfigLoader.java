package com.guardian.framework.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigLoader {

    private static Config config;

    static {
        // Load application.conf
        config = ConfigFactory.parseResources("application.conf").resolve();
    }

    public static String getBaseUrl() {
        String env = config.hasPath("env") ? config.getString("env") : "dev";
        System.out.println("ENV = " + env);
        return config.getConfig("environments." + env).getString("baseUrl");
    }
    public static String getUiUrl() {
        String env = config.hasPath("env") ? config.getString("env") : "dev";
        return config.getConfig(env).getString("uiUrl");
    }
}