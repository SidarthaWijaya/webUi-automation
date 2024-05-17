Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    And I click on login button
    Then I should be redirected to the homepage

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter invalid username and password
    And I click on login button
    Then I should see an error message
