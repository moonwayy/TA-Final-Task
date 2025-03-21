# TA-Java-Final-task
# Saucedemo Login Automation Tests

## Overview
This project automates the testing of the login form on [Saucedemo](https://www.saucedemo.com/) using Selenium WebDriver. It includes test scenarios that validate different login conditions, ensuring robust functionality.

## Technologies Used
- **Test Automation Tool**: Selenium WebDriver
- **Project Builder**: Maven
- **Test Runner**: TestNG
- **Assertions**: AssertJ
- **Browsers**: Firefox, Chrome
- **Locators**: CSS Selectors
- **Logging**: SLF4J (Optional)
- **Design Patterns**: Singleton, Adapter, Strategy (Optional)
- **Test Automation Approach**: BDD (Optional)

## Test Scenarios
### UC-1: Login Form with Empty Credentials
1. Enter any credentials in the **Username** and **Password** fields.
2. Clear both input fields.
3. Click the **Login** button.
4. Validate the error message: **"Username is required"**.

### UC-2: Login Form with Only Username Entered
1. Enter any credentials in the **Username** field.
2. Enter a password.
3. Clear the **Password** field.
4. Click the **Login** button.
5. Validate the error message: **"Password is required"**.

### UC-3: Successful Login with Valid Credentials
1. Enter an accepted username from the provided test data.
2. Enter the password: **"secret_sauce"**.
3. Click the **Login** button.
4. Verify the dashboard title: **"Swag Labs"**.

## Additional Features
- **Parallel Execution**: Tests run simultaneously on different browsers to improve efficiency.
- **Data Provider**: TestNG’s DataProvider is used to parameterize test cases.
- **Logging**: SLF4J logging framework (if enabled) for better debugging and tracking.

## How to Run the Tests
1. Clone the repository.
2. Navigate to the project directory.
3. Run the tests using Maven:
   ```sh
   mvn clean test
   ```
4. View test reports in the **target/surefire-reports** directory.
