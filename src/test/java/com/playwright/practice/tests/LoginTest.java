// package com.playwright.practice.tests;

// // import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import com.microsoft.playwright.*;
// import com.playwright.practice.config.SecretsConfig;
// import com.playwright.practice.pages.LoginPage;
// import com.playwright.practice.utils.BrowserFactory;

// public class LoginTest {

//     private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginTest.class);

//     private static Browser browser;
//     private static BrowserContext context;
//     private static Page page;
//     private static SecretsConfig config;

//     @BeforeAll
//     public static void setup() {
//         logger.info("Setting up the Playwright environment starts...");
//         browser = BrowserFactory.getBrowser();
//         context = browser.newContext();
//         page = context.newPage();
//         config = new SecretsConfig();
//         logger.info("Setting up the Playwright environment completes...");
//     }

//     @Test
//     public void loginTest() {
//         LoginPage loginPage = new LoginPage(page);
//         page.navigate(config.getUrl());
//         loginPage.clickOnEmailOptionBtn();
//         loginPage.isEmailInputVisible();
//         loginPage.isPasswordInputVisible();
//         loginPage.isLoginButtonVisible();
//         loginPage.enterEmail(config.getStudentEmail());
//         loginPage.enterPassword(config.getStudentPassword());
//         loginPage.clickLoginButton();
//     }

//     @AfterAll
//     public static void teardown() {
//         BrowserFactory.closePlaywright();
//     }
// }

package com.playwright.practice.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
import com.playwright.practice.config.SecretsConfig;
import com.playwright.practice.pages.LoginPage;
import com.playwright.practice.utils.BrowserFactory;

public class LoginTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    private static Browser browser;
    private static SecretsConfig config;

    @BeforeAll
    public static void setup() {
        logger.info("Setting up the Playwright environment starts...");
        browser = BrowserFactory.getBrowser();
        config = new SecretsConfig();
        logger.info("Setting up the Playwright environment completes...");
    }

    @Test
    public void loginTest() {
        // Perform login in the initial context
        // performLoginInNewContext();

        // Perform login in a new context
        // performLoginInNewContext();
    }

    private static Browser.NewContextOptions getBrowserContextOptions() {
        return new Browser.NewContextOptions().setColorScheme(ColorScheme.DARK);
    }

    private void performLoginInNewContext() {
        // Create a new context for a fresh session
        BrowserContext context = browser.newContext(getBrowserContextOptions());
        Page page = context.newPage();

        logger.info("Navigating to: {}", config.getUrl());
        page.navigate(config.getUrl());

        // Perform login actions
        LoginPage loginPage = new LoginPage(page);
        loginPage.clickOnEmailOptionBtn();
        loginPage.isEmailInputVisible();
        loginPage.isPasswordInputVisible();
        loginPage.isLoginButtonVisible();
        loginPage.enterEmail(config.getStudentEmail());
        loginPage.enterPassword(config.getStudentPassword());
        loginPage.clickLoginButton();

        // Optionally, close the context if not needed anymore
        // context.close();
    }

    @AfterAll
    public static void teardown() {
        if (browser != null) {
            browser.close();
        }
    }
}
