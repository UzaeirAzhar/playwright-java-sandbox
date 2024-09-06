package com.playwright.practice.tests.integration;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.*;
import com.playwright.practice.helper.DashboardHelper;

public class DashboardTest extends BaseTest {
    @Test
    public void dashboardTest() {
        BrowserContext teacherContext = createNewContext();
        DashboardHelper.loginAndNavigateToDashboard(page, teacherContext, config.getUrl(), config.getTeacherEmail(),
                config.getTeacherPassword(), true);

        BrowserContext studentContext = createNewContext();
        DashboardHelper.loginAndNavigateToDashboard(page, studentContext, config.getUrl(), config.getStudentEmail(),
                config.getStudentPassword(), false);

        // page.pause();
    }
}
