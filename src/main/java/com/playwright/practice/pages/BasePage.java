package com.playwright.practice.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.practice.tests.LoginTest;

public abstract class BasePage {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginTest.class);
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void navigateTo(String url) {
        logger.info("Navigating to url");
        page.navigate(url);
    }

    protected void click(Locator locator) {
        logger.info("click on element");
        locator.click();
    }

    protected void fill(Locator locator, String text) {
        logger.info("typed text into text field");
        locator.fill(text);
    }

    protected String getText(Locator locator) {
        return locator.textContent();
    }

    protected boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

    protected void isAttached(Locator locator) {
        assertThat(locator).isAttached();
    }

    protected void waitForElementToBeVisible(Locator locator) {
        locator.waitFor();
    }

}
