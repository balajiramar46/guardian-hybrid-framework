package com.guardian.framework.recipes;

import java.util.ArrayList;
import java.util.List;

import com.guardian.framework.core.Step;
import com.guardian.framework.rails.ui.UiStep;
import com.guardian.framework.reader.CodegenReader;

public class GoogleTitleRecipe {

    public static List<Step> getSteps() {

        List<Step> steps = new ArrayList<>();

        steps.add(new UiStep(CodegenReader.getUi("googleUrl")));  // reuse existing step

        return steps;
    }
}