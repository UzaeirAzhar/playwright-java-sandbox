package com.playwright.practice.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.practice.selectors.Selectors;

public class DashboardPage extends BasePage {

    public DashboardPage(Page page) {
        super(page);
    }

    private Locator welcomeSectionHeader() {
        return page.getByTestId(Selectors.DASHBOARD_WELCOME_SECTION.getSelector());
    }

    private Locator newSection() {
        return page.getByTestId(Selectors.DASHBOARD_NEWS_SECTION.getSelector());
    }

    private Locator publishedTaskSection() {
        return page.getByTestId(Selectors.DASHBOARD_PUBLISHED_TASKS_SECTION.getSelector());
    }

    private Locator draftTaskSection() {
        return page.getByTestId(Selectors.DASHBOARD_DRAFT_TASK_SECTION.getSelector());
    }

    public void isWelcomeSectionVisible() {
        waitForElementToBeVisible(welcomeSectionHeader());
        isVisible(welcomeSectionHeader());
        waitForElementToBeVisible(welcomeSectionHeader());
    }

    public void isNewsSectionInDashboardVisible() {
        waitForElementToBeVisible(newSection());
        isVisible(newSection());
        waitForElementToBeVisible(newSection());
    }

    public void isPublishedTasksSectionVisible() {
        waitForElementToBeVisible(publishedTaskSection());
        isVisible(publishedTaskSection());
        waitForElementToBeVisible(publishedTaskSection());
    }

    public void isDraftTaskSectionVisible() {
        waitForElementToBeVisible(draftTaskSection());
        isVisible(draftTaskSection());
        waitForElementToBeVisible(draftTaskSection());
    }

}
