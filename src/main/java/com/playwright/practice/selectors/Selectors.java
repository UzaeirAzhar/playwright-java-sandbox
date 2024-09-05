package com.playwright.practice.selectors;

public enum Selectors {
    EMAIL_BTN_SEL("submit-cloud-site"),
    EMAIL_INPUT_SEL("username-email"),
    PASSWORD_INPUT_SEL("password-email"),
    LOGIN_BTN_SEL("submit-login-email"),
    DASHBOARD_WELCOME_SECTION("welcome-section"),
    DASHBOARD_NEWS_SECTION("news-section");

    private final String selector;

    Selectors(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
