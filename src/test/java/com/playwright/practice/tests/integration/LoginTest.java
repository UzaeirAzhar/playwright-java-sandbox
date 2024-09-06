package com.playwright.practice.tests.integration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.BrowserContext;
import com.playwright.practice.helper.LoginHelper;

public class LoginTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void loginTest() {
        logger.info("Login as a teacher....");
        BrowserContext teacherContext = createNewContext();
        page = teacherContext.newPage();
        LoginHelper.login(page, config.getUrl(), config.getTeacherEmail(), config.getTeacherPassword());

        logger.info("Login as a student....");
        BrowserContext studentContext = createNewContext();
        page = studentContext.newPage();
        LoginHelper.login(page, config.getUrl(), config.getStudentEmail(), config.getStudentPassword());

        logger.info("Login as an invalid user....");
        BrowserContext invalidLogin = createNewContext();
        page = invalidLogin.newPage();
        LoginHelper.invalidLogin(page, config.getUrl());
    }
}
