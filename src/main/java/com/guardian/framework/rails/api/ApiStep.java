package com.guardian.framework.rails.api;

import com.guardian.framework.core.Step;
import com.guardian.framework.core.Context;
import com.guardian.framework.config.ConfigLoader;

import io.restassured.RestAssured;

public class ApiStep implements Step {

    private String endpoint;

    public ApiStep(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void execute(Context ctx) {
        String url = ConfigLoader.getBaseUrl() + endpoint;
        int status = RestAssured.get(url).statusCode();

        ctx.data.put("apiStatus", status);
        System.out.println("API Status: " + status);
        if (status == 200) {
            ctx.data.put("apiStatus", "PASS");
        } else {
            ctx.data.put("apiStatus", "FAIL");
            throw new RuntimeException("API failed with status: " + status);
        }
    }
}