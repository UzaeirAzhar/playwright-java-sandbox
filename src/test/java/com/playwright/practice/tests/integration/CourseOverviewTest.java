package com.playwright.practice.tests.integration;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserContext;
import com.playwright.practice.helper.CourseOverviewHelper;

public class CourseOverviewTest extends BaseTest {
    @Test
    public void roomOverviewTest() {
        BrowserContext teacherContext = createNewContext();
        CourseOverviewHelper.loginAndNavigateToCourseOverview(page, teacherContext, config.getUrl(),
                config.getTeacherEmail(),
                config.getTeacherPassword());
    }
}
