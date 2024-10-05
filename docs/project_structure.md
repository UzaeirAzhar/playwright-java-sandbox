# Project Structure

This project follows a structured format to organize code effectively, separating tests, page objects, utilities, and configuration files. Below is an outline of the key folders and files:

```bash
.
├── pom.xml                                  # Project dependencies and build configuration
├── README.md                                # Project documentation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.playwright.practice
│   │   │   │   ├── config
│   │   │   │   │   └── SecretsConfig.java   # Configurations for secrets management
│   │   │   │   ├── helper
│   │   │   │   │   ├── LoginHelper.java     # Helper for login functionalities
│   │   │   │   │   ├── DashboardHelper.java # Helper for dashboard functionalities
│   │   │   │   │   └── CourseOverviewHelper.java # Helper for course overview functionalities
│   │   │   │   ├── pages
│   │   │   │   │   ├── BasePage.java        # Base Page containing shared methods for all pages
│   │   │   │   │   ├── DashboardPage.java   # Dashboard Page object
│   │   │   │   │   ├── CourseOverviewPage.java # Course Overview Page object
│   │   │   │   │   └── LoginPage.java       # Login Page object
│   │   │   │   ├── scripts
│   │   │   │   │   └── run-test.sh          # Script for running tests locally
│   │   │   │   ├── selectors
│   │   │   │   │   └── Selectors.java       # Selectors for UI elements
│   │   │   │   ├── utils
│   │   │   │   │   ├── BrowserFactory.java  # Browser factory to create and manage browser instances
│   │   │   │   │   └── PageFactory.java     # Page factory for creating page objects dynamically
│   │   ├── resources
│   │   │   ├── secrets.properties           # Secrets configuration
│   │   │   └── configurations.properties    # General configurations for the project
│   ├── test
│   │   ├── java
│   │   │   ├── com.playwright.practice.tests.integration
│   │   │   │   ├── BaseTest.java            # Base Test containing setup/teardown for tests
│   │   │   │   ├── CourseOverviewTest.java  # Tests for course overview functionality
│   │   │   │   ├── LoginTest.java           # Tests for login functionality
│   │   │   │   └── DashboardTest.java       # Tests for dashboard functionality
```
