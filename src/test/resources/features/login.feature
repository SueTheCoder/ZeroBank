
Feature: Navigating to Zero Bank Login page

  Background: Login Page
    Given user is on the login page

  Scenario: Only authorized users should be able to login to the application
    Given the user fills "username" and "password" text boxes and clicks to Keep me signed in checkbox
    And the user clicks to sign in button
    Then Account summary page should be	displayed

    Scenario: Users with blank username or wrong password should not be able to login.
      Given the user leave blank username and password text boxes
      Then error message should be displayed
  @login
  Scenario: Users with wrong username or wrong password should not be able to login.
    Given the user fills invalid "user123" and "pass123" text boxes
    Then error message should be displayed
@forgotPass
    Scenario: Users can click "Forgot your password ?" link and reset their password
      Given the user clicks Forgot your password ? link
      And the user fills email text box
      Then the user should see the Your password will be sent to the following email: text


