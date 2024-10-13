# Page Object Model (POM)

This project uses the Page Object Model (POM) pattern to organize the UI interactions and test logic separately. Each page of the web application has a corresponding Java class in the pages/ package that contains the locators and actions related to that page.

- **BasePage:** Contains common actions like navigation, clicks, and waits.

- **LoginPage, DashboardPage, CourseOverviewPage:** These represent different pages of the application, each with methods to interact with the page elements.

- **BrowserFactory:** This utility class manages browser instances using Playwright. It handles browser creation, setup, and teardown, supporting different browsers such as Chrome, Firefox, and WebKit. The factory abstracts the complexity of browser management, making it easy to initialize browser instances for testing.

- **PageFactory:** A utility to dynamically instantiate page objects at runtime, reducing boilerplate code. It creates page objects using reflection, allowing smooth transitions between different pages during the test execution.