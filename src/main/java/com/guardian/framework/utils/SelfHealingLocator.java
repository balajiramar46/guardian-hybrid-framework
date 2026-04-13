package com.guardian.framework.utils;

import org.openqa.selenium.By;

public class SelfHealingLocator {

    public static By get(String primary, String fallback) {
        try {
            return By.xpath(primary);
        } catch (Exception e) {
            return By.xpath(fallback);
        }
    }
}