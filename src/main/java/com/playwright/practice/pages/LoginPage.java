package com.playwright.practice.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.practice.selectors.Selectors;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    private Locator emailOptionBtn() {
        return page.getByTestId(Selectors.EMAIL_BTN_SEL.getSelector()).last();
    }

    private Locator emailInput() {
        return page.getByTestId(Selectors.EMAIL_INPUT_SEL.getSelector()).last();
    }

    private Locator passwordInput() {
        return page.getByTestId(Selectors.PASSWORD_INPUT_SEL.getSelector()).last();
    }

    private Locator loginButton() {
        return page.getByTestId(Selectors.LOGIN_BTN_SEL.getSelector()).last();
    }

    public void clickOnEmailOptionBtn() {
        click(emailOptionBtn());
    }

    public void enterEmail(String email) {
        fill(emailInput(), email);
    }

    public void enterPassword(String password) {
        fill(passwordInput(), password);
    }

    public void clickLoginButton() {
        click(loginButton());
    }

    public void isEmailInputVisible() {
        waitForElementToBeVisible(emailInput());
        assertThat(emailInput()).isVisible();
        assertThat(emailInput()).isAttached();
    }

    public void isPasswordInputVisible() {
        waitForElementToBeVisible(passwordInput());
        assertThat(passwordInput()).isVisible();
        assertThat(passwordInput()).isAttached();
    }

    public boolean isLoginButtonVisible() {
        return isVisible(loginButton());
    }

}
