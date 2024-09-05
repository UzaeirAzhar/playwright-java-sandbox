package com.playwright.practice.tests.integration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.*;
import com.playwright.practice.config.SecretsConfig;
import com.playwright.practice.pages.DashboardPage;
import com.playwright.practice.pages.LoginPage;
import com.playwright.practice.utils.BrowserFactory;

public class DashboardTest {

    private static final Logger logger = LoggerFactory.getLogger(DashboardTest.class);

    private static Browser browser;
    private static SecretsConfig config;
    private Page page;

    @BeforeAll
    public static void setup() {
        logger.info("Setting up the Playwright environment starts...");
        browser = BrowserFactory.getBrowser();
        config = new SecretsConfig();
        logger.info("Setting up the Playwright environment completes...");
    }

    @Test
    public void dashboardTest() {

        // Perform login as teacher and check dashboard
        performLoginAsTeacher();
        performDashboardTestForTeacher();

        // Perform login as student and check dashboard
        performLoginAsStudent();
        performDashboardTestForStudent();

        page.pause();
    }

    private void performLoginAsStudent() {
        logger.info("Logging in as Student...");
        BrowserContext studentContext = BrowserFactory.getNewBrowserContext(browser);
        Page studentPage = studentContext.newPage();

        studentPage.navigate(config.getUrl());

        LoginPage loginPage = new LoginPage(studentPage);
        loginPage.clickOnEmailOptionBtn();
        loginPage.isEmailInputVisible();
        loginPage.isPasswordInputVisible();
        loginPage.isLoginButtonVisible();
        loginPage.enterEmail(config.getStudentEmail());
        loginPage.enterPassword(config.getStudentPassword());
        loginPage.clickLoginButton();

        // Set the page for dashboard test to studentPage
        this.page = studentPage;
    }

    private void performLoginAsTeacher() {
        logger.info("Logging in as Teacher...");
        BrowserContext teacherContext = BrowserFactory.getNewBrowserContext(browser);
        Page teacherPage = teacherContext.newPage();

        teacherPage.navigate(config.getUrl());

        LoginPage loginPage = new LoginPage(teacherPage);
        loginPage.clickOnEmailOptionBtn();
        loginPage.isEmailInputVisible();
        loginPage.isPasswordInputVisible();
        loginPage.isLoginButtonVisible();
        loginPage.enterEmail(config.getTeacherEmail());
        loginPage.enterPassword(config.getTeacherPassword());
        loginPage.clickLoginButton();

        // Set the page for dashboard test to teacherPage
        this.page = teacherPage;
    }

    private void performDashboardTestForTeacher() {
        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.isWelcomeSectionVisible();
        dashboardPage.isNewsSectionInDashboardVisible();
        dashboardPage.isPublishedTasksSectionVisible();
        dashboardPage.isDraftTaskSectionVisible();
    }

    private void performDashboardTestForStudent() {
        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.isWelcomeSectionVisible();
        dashboardPage.isNewsSectionInDashboardVisible();
        dashboardPage.isPublishedTasksSectionVisible();
    }

    @AfterAll
    public static void teardown() {
        if (browser != null) {
            browser.close();
        }
    }
}
