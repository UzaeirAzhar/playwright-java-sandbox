package com.playwright.practice.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.Page;
import com.playwright.practice.pages.LoginPage;
import com.playwright.practice.utils.PageFactory;

public class LoginHelper {
    private static final Logger logger = LoggerFactory.getLogger(LoginHelper.class);

    public static void login(Page page, String url, String email, String password) {
        logger.info("Login as a user...");
        page.navigate(url);
        LoginPage loginPage = PageFactory.getPage(LoginPage.class, page);
        loginPage.clickOnEmailOptionBtn();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public static void invalidLogin(Page page, String url) {
        login(page, url, "abc@gmx.de", "asdfgh");
        LoginPage loginPage = PageFactory.getPage(LoginPage.class, page);
        loginPage.assertInvalidLoginNotification();
    }
}
