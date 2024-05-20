Feature: Login Functionality

  @login
  Scenario: Successful login
    Given I open the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see the products page

    @web
    Scenario: Unsuccessful login with invalid credentials
      Given I open the login page
      When I enter username "locked_out_user"
      And I enter password "secret_sauce"
      And I click the login button
      Then the user should see an error message "invalid credential"

      @web
      Scenario: Boundary test with empty username and valid password
        Given I open the login page
        When I enter username ""
        And I enter password "secret_sauce"
        And I click the login button
        Then the user should see an error message "username empty"

      @web
      Scenario: Boundary test with valid username and empty password
        Given I open the login page
        When I enter username "standard_user"
        And I enter password ""
        And I click the login button
        Then the user should see an error message "Password empty"



