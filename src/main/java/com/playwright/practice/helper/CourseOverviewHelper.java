package com.playwright.practice.helper;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.practice.pages.CourseOverviewPage;
import com.playwright.practice.utils.PageFactory;

public class CourseOverviewHelper {
    public static void loginAndNavigateToCourseOverview(Page page, BrowserContext context, String url, String email,
            String password) {
        page = context.newPage();
        LoginHelper.login(page, url, email, password);

        assertCourseOverviewNavigation(page);
    }

    private static void assertCourseOverviewNavigation(Page page) {
        CourseOverviewPage courseOverview = PageFactory.getPage(CourseOverviewPage.class, page);
        courseOverview.clickOnCourseOverviewInSideMenu();
        courseOverview.assertSearchFieldInCourseViewIsVisible();
    }
}
