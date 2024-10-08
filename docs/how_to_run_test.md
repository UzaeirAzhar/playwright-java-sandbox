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
