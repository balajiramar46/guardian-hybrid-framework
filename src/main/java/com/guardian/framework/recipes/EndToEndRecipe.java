package com.guardian.framework.recipes;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.guardian.framework.core.Step;
import com.guardian.framework.rails.api.ApiStep;
import com.guardian.framework.rails.ui.UiStep;
import com.guardian.framework.reader.CodegenReader;

public class EndToEndRecipe {

    public static List<Step> getSteps(JSONObject testData) {

        List<Step> steps = new ArrayList<>();

        steps.add(new ApiStep(testData.getString("api")));
        //steps.add(new UiStep(testData.getString("ui")));
        steps.add(new UiStep(CodegenReader.getUi(testData.getString("ui"))));
        return steps;
    }
}