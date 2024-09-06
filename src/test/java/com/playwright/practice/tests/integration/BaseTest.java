package com.playwright.practice.tests.integration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.practice.config.SecretsConfig;
import com.playwright.practice.utils.BrowserFactory;

public abstract class BaseTest {

    protected static Browser browser;
    protected static SecretsConfig config;
    protected Page page;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    public static void globalSetup() {
        logger.info("Setting up Playwright environment...");
        browser = BrowserFactory.getBrowser();
        config = new SecretsConfig();
        logger.info("Playwright environment setup complete.");
    }

    @AfterAll
    public static void globalTeardown() {
        if (browser != null) {
            browser.close();
        }
    }

    protected BrowserContext createNewContext() {
        return BrowserFactory.getNewBrowserContext(browser);
    }
}
