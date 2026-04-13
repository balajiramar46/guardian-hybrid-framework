package com.guardian.framework.rails.ui;

import com.guardian.framework.core.Context;
import com.guardian.framework.core.Step;
import com.guardian.framework.driver.DriverFactory;
import com.guardian.framework.pages.GooglePage;

import org.openqa.selenium.WebDriver;

public class UiStep implements Step {

    private String url;

    public UiStep(String url) {
        this.url = url;
    }

    @Override
    public void execute(Context ctx) {

        WebDriver driver = DriverFactory.getDriver();

        System.out.println("Opening URL: " + url);

        GooglePage page = new GooglePage(driver);

        page.open(url);

        System.out.println("UI Opened");

        String title = page.getTitle();
        System.out.println("Page Title: " + title);

        if (title != null && title.toLowerCase().contains("google")) {
            ctx.data.put("uiStatus", "PASS");
        } else {
            ctx.data.put("uiStatus", "FAIL");
            throw new RuntimeException("UI validation failed. Title was: " + title);
        }

        // ✅ Always quit at end
        DriverFactory.quitDriver();
    }
}