package com.guardian.framework.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CodegenReader {

    public static void readApps() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("inventory.json")));
        JSONObject obj = new JSONObject(content);

        JSONArray apps = obj.getJSONArray("apps");

        for (int i = 0; i < apps.length(); i++) {
            System.out.println("App: " + apps.getJSONObject(i).getString("name"));
        }
    }
}