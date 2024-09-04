package com.playwright.practice.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.*;
import com.playwright.practice.config.SecretsConfig;
import com.playwright.practice.selectors.Selectors;

public class LoginTest {
    public static void main(String[] args) {
        loginTest();
        // try (Playwright playwright = Playwright.create()) {
        // Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
        // .setHeadless(false));
        // BrowserContext context = browser.newContext();
        // Page page = context.newPage();
        // SecretsConfig config = new SecretsConfig();

        // page.navigate(config.getUrl());
        // assertThat(page.getByTestId(Selectors.EMAIL_BTN_SEL.getSelector()).last()).isAttached();
        // page.getByTestId(Selectors.EMAIL_BTN_SEL.getSelector()).last().click();
        // assertThat(page.getByTestId(Selectors.EMAIL_INPUT_SEL.getSelector()).last()).isVisible();
        // page.getByTestId(Selectors.EMAIL_INPUT_SEL.getSelector()).last().fill(config.getStudentEmail());
        // page.getByTestId(Selectors.PASSWORD_INPUT_SEL.getSelector()).last().fill(config.getStudentPassword());
        // page.getByTestId(Selectors.LOGIN_BTN_SEL.getSelector()).last().click();
        // // page.pause();
        // playwright.close();
        // }
    }

    public static void loginTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            SecretsConfig config = new SecretsConfig();

            page.navigate(config.getUrl());
            assertThat(page.getByTestId(Selectors.EMAIL_BTN_SEL.getSelector()).last()).isAttached();
            page.getByTestId(Selectors.EMAIL_BTN_SEL.getSelector()).last().click();
            assertThat(page.getByTestId(Selectors.EMAIL_INPUT_SEL.getSelector()).last()).isVisible();
            page.getByTestId(Selectors.EMAIL_INPUT_SEL.getSelector()).last().fill(config.getStudentEmail());
            page.getByTestId(Selectors.PASSWORD_INPUT_SEL.getSelector()).last().fill(config.getStudentPassword());
            page.getByTestId(Selectors.LOGIN_BTN_SEL.getSelector()).last().click();
            // page.pause();
            playwright.close();
        }
    }
}