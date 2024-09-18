package com.playwright.practice.helper;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.practice.pages.DashboardPage;

public class DashboardHelper {
    public static void loginAndNavigateToDashboard(Page page, BrowserContext context, String url, String email,
            String password, boolean isTeacher) {
        page = context.newPage();
        LoginHelper.login(page, url, email, password);

        assertDashboardNavigation(page, isTeacher);
    }

    private static void assertDashboardNavigation(Page page, boolean isTeacher) {
        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.isWelcomeSectionVisible();
        dashboardPage.isNewsSectionInDashboardVisible();
        if (isTeacher) {
            dashboardPage.isDraftTaskSectionVisible();
        }
    }

}
