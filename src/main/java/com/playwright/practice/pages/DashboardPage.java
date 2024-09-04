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

    public void isWelcomeSectionVisible() {
        waitForElementToBeVisible(welcomeSectionHeader());
        isVisible(welcomeSectionHeader());
        waitForElementToBeVisible(welcomeSectionHeader());
    }

}
