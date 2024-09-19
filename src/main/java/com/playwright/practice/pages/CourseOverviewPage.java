package com.playwright.practice.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.practice.selectors.Selectors;

public class CourseOverviewPage extends BasePage {

    public CourseOverviewPage(Page page) {
        super(page);
    }

    private Locator courseOverviewSideMenuBar() {
        return page.getByTestId(Selectors.COURSE_OVERVIEW_SIDE_MENU_BAR_SEL.getSelector());
    }

    private Locator courseOverviewSearchField() {
        return page.getByTestId(Selectors.COURSE_OVERVIEW_SEARCH_FIELD_SEL.getSelector());
    }

    public void clickOnCourseOverviewInSideMenu() {
        assertThat(courseOverviewSideMenuBar()).isVisible();
        courseOverviewSideMenuBar().click();
    }

    public void assertSearchFieldInCourseViewIsVisible() {
        assertThat(courseOverviewSearchField()).isVisible();
    }

}
