# How to Run Tests

### Using Maven

You can run the tests by using Maven commands:

1) Run all tests:

    ```bash
    mvn test
    ```

2) Run tests with specific profiles:

- Integration Tests:

    ```bash
    mvn test -P integration-tests
    ```

- End-to-End Tests:

    ```bash
    mvn test -P e2e-tests
    ```

- API Tests:

    ```bash
    mvn test -P api-tests
    ```

### Using the Script

There is a Bash script [run-test.sh](../src/main/java/com/playwright/practice/scripts/run-test.sh) to run tests locally without Maven commands. To use the script:

1) Give it execution permission (if not already):

    ```bash
    chmod +x src/main/java/com/playwright/practice/scripts/run-test.sh
    ```

2) Run the script:

    ```bash
    ./src/main/java/com/playwright/practice/scripts/run-test.sh [test-type]
    ```

Example:

```bash
./src/main/java/com/playwright/practice/scripts/run-test.sh i -h true -b c -t LoginTest
```

- i runs integration tests.
- -h true runs tests in headless mode.
- -b c runs tests in Chrome browser.
- -t allows specifying a test class to run.
