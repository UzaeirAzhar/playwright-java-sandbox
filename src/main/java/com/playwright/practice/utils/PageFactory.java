package com.playwright.practice.utils;

import com.microsoft.playwright.Page;
import com.playwright.practice.pages.BasePage;
import com.playwright.practice.pages.DashboardPage;
import com.playwright.practice.pages.LoginPage;

public class PageFactory {
    public static <T extends BasePage> T getPage(Class<T> pageClass, Page page) {
        try {
            return pageClass.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page: " + pageClass.getName(), e);
        }
    }

    public static LoginPage getLoginPage(Page page) {
        return getPage(LoginPage.class, page);
    }

    public static DashboardPage getDashboardPage(Page page) {
        return getPage(DashboardPage.class, page);
    }
}
