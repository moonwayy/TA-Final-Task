Feature: Login Page Functionality

  As a user
  I want to test the login form on the Swag Labs website
  So that I can verify error messages and successful login behavior

  Background:
    Given I am on the login page

  Scenario: Login with empty credentials
    When I enter "testUser" in the username field
    And I enter "testPassword" in the password field
    And I clear the username and password fields
    And I click the login button
    Then I should see an error message "Username is required"

  Scenario: Login with username only
    When I enter "testUser" in the username field
    And I enter "testPassword" in the password field
    And I clear the password field
    And I click the login button
    Then I should see an error message "Password is required"

  Scenario: Successful login with valid credentials
    When I enter a valid username in the username field
    And I enter "secret_sauce" in the password field
    And I click the login button
    And I should be redirected to the dashboard
    Then the page title should be "Swag Labs"
