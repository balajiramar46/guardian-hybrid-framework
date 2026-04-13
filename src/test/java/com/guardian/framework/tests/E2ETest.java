package com.guardian.framework.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.guardian.framework.core.Engine;
import com.guardian.framework.reader.CodegenReader;
import com.guardian.framework.recipes.EndToEndRecipe;

@Listeners(com.guardian.framework.listeners.TestListener.class)
public class E2ETest {

    @DataProvider(name = "testData", parallel = true)
    public Object[] getData() {

        String runType = System.getProperty("type", "smoke");

        JSONArray tests = CodegenReader.getTestsByType(runType);

        Object[] data = new Object[tests.length()];

        for (int i = 0; i < tests.length(); i++) {
            data[i] = tests.getJSONObject(i);
        }

        return data;
    }

    @Test(dataProvider = "testData")
    public void dynamicTestFlow(JSONObject testData) {

        System.out.println("Running: " + testData.getString("name"));

        Engine.run(EndToEndRecipe.getSteps(testData));
    }
}