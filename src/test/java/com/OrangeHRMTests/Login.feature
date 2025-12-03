Feature: Login functionality

  Scenario: Successful login
    Given User is on login page
    When User enters valid credentials
    And Clicks the login button
    Then User should be redirected to home page

