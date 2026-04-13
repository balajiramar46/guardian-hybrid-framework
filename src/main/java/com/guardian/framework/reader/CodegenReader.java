package com.guardian.framework.reader;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class CodegenReader {

    private static JSONObject json;

    static {
        try {
            String content = new String(
                    Files.readAllBytes(Paths.get("inventory.json"))
            );

            json = new JSONObject(content);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load inventory.json", e);
        }
    }

    // API
    public static String getApi(String key) {
        return json.getJSONObject("api").getString(key);
    }

    // UI
    public static String getUi(String key) {
        return json.getJSONObject("ui").getString(key);
    }

    // ALL TESTS
    public static JSONArray getTests() {
        return json.getJSONArray("tests");
    }

    // FILTERED TESTS (NEW 🔥)
    public static JSONArray getTestsByType(String type) {

        JSONArray allTests = json.getJSONArray("tests");
        JSONArray filtered = new JSONArray();

        for (int i = 0; i < allTests.length(); i++) {

            JSONObject test = allTests.getJSONObject(i);

            if (test.getString("type").equalsIgnoreCase(type)) {
                filtered.put(test);
            }
        }

        return filtered;
    }
}