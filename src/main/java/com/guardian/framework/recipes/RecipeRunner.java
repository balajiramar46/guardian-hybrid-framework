package com.guardian.framework.recipes;

import com.guardian.framework.core.*;

import java.util.List;

public class RecipeRunner {

    public static void run(List<Step> steps) {
    	Engine.run(steps);
        //System.out.println(ctx.data);
    }
}