package com.playwright.practice.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
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
        // Perform login as student and check dashboard
        performLoginAsStudent();
        performDashboardTest();

        // Perform login as teacher and check dashboard
        performLoginAsTeacher();
        performDashboardTest();

        page.pause();
    }

    private static Browser.NewContextOptions getBrowserContextOptions() {
        return new Browser.NewContextOptions().setColorScheme(ColorScheme.DARK);
    }

    private void performLoginAsStudent() {
        logger.info("Logging in as Student...");
        BrowserContext studentContext = browser.newContext(getBrowserContextOptions());
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
        BrowserContext teacherContext = browser.newContext(getBrowserContextOptions());
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

    private void performDashboardTest() {
        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.isWelcomeSectionVisible();
        dashboardPage.isNewsSectionInDashboardVisible();
    }

    @AfterAll
    public static void teardown() {
        if (browser != null) {
            browser.close();
        }
    }
}
