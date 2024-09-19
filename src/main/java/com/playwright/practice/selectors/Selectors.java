package com.playwright.practice.selectors;

public enum Selectors {
    EMAIL_BTN_SEL("submit-cloud-site"),
    EMAIL_INPUT_SEL("username-email"),
    PASSWORD_INPUT_SEL("password-email"),
    LOGIN_BTN_SEL("submit-login-email"),
    DASHBOARD_WELCOME_SECTION("welcome-section"),
    DASHBOARD_NEWS_SECTION("news-section"),
    DASHBOARD_PUBLISHED_TASKS_SECTION("published-tasks-section"),
    DASHBOARD_DRAFT_TASK_SECTION("private-tasks-section"),
    INVALID_LOGIN_NOTIFICATION("notification"),
    COURSE_OVERVIEW_SIDE_MENU_BAR_SEL("Course-Overview"),
    COURSE_OVERVIEW_SEARCH_FIELD_SEL("search-field-course");

    private final String selector;

    Selectors(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
