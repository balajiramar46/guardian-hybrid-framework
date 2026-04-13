package com.guardian.framework.core;

import java.util.List;

public class Engine {

    public static void run(List<Step> steps) {
        Context ctx = new Context();

        for (Step step : steps) {
            step.execute(ctx);
        }

        System.out.println("Final Context Data: " + ctx.data);
    }
}