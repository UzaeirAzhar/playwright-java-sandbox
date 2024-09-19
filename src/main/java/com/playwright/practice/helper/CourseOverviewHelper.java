package com.playwright.practice.helper;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.practice.pages.CourseOverviewPage;

public class CourseOverviewHelper {
    public static void loginAndNavigateToCourseOverview(Page page, BrowserContext context, String url, String email,
            String password) {
        page = context.newPage();
        LoginHelper.login(page, url, email, password);

        assertCourseOverviewNavigation(page);
    }

    private static void assertCourseOverviewNavigation(Page page) {
        CourseOverviewPage courseOverview = new CourseOverviewPage(page);
        courseOverview.clickOnCourseOverviewInSideMenu();
        courseOverview.assertSearchFieldInCourseViewIsVisible();
    }
}
