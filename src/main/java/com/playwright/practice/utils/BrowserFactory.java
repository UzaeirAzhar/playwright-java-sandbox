package com.playwright.practice.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    private static Playwright playwright;

    private static void initializePlaywright() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
    }

    private static BrowserType.LaunchOptions getBrowserOptions() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        return new BrowserType.LaunchOptions().setHeadless(headless);
    }

    public static Browser getBrowser() {
        initializePlaywright(); // Ensure Playwright is initialized before getting browser
        String browserType = System.getProperty("browser", "firefox");
        switch (browserType.toLowerCase()) {
            case "chrome":
                return playwright.chromium().launch(getBrowserOptions());
            case "safari":
                return playwright.webkit().launch(getBrowserOptions());
            default:
                return playwright.firefox().launch(getBrowserOptions());
        }
    }

    public static void closePlaywright() {
        if (playwright != null) {
            playwright.close();
        }
    }
}
