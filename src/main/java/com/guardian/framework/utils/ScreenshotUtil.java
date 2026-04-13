package com.guardian.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.guardian.framework.driver.DriverFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String capture(String testName) {

        try {
            WebDriver driver = DriverFactory.getDriver();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));

            return path;

        } catch (Exception e) {
            return null;
        }
    }
}