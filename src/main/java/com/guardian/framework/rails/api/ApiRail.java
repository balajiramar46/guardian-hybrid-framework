package com.guardian.framework.rails.api;

import com.guardian.framework.core.Context;
import com.guardian.framework.core.Step;
import io.restassured.RestAssured;

public class ApiRail implements Step {

    @Override
    public void execute(Context ctx) {
        int status = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1").statusCode();
        ctx.data.put("apiStatus", status);
        System.out.println("API Status: " + status);
    }
}