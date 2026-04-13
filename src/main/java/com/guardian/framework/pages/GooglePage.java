package com.guardian.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By searchBox = By.name("q");

    // Actions
    public void open(String url) {
        driver.get(url);
    }

    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}