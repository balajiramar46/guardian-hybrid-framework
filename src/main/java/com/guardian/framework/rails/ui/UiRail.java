package com.guardian.framework.rails.ui;

import com.guardian.framework.core.Context;
import com.guardian.framework.core.Step;
import com.guardian.framework.driver.DriverFactory;
import com.guardian.framework.utils.SelfHealingLocator;
import org.openqa.selenium.By;

public class UiRail implements Step {

    @Override
    public void execute(Context ctx) {

    	var driver = DriverFactory.getDriver();
    	driver.get("https://google.com"); // or your URL
        //driver.get("https://example.com");

        By locator = SelfHealingLocator.get("//h1", "//h2");
        driver.findElement(locator);

        ctx.data.put("uiStatus", "PASS");

        driver.quit();
    }
}