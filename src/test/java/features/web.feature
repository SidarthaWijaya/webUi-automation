Feature: Test Automation Web

  @web
  Scenario: Test web login normal
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click login button
    Then user verify see cart icon

  @web
  Scenario: Test web login lock user
    Given user go to login page
    And user input username "locked_out_user"
    And user input pwd "secret_sauce"
    And user click login button
    Then user verify see errmsg "user has been locked out"

  @web
  Scenario: Test web login wrong password
    Given user go to login page
    And user input username "locked_out_user"
    And user input pwd "DFAW"
    And user click login button
    Then user verify see errmsg "Username and password do not match any user"

  @web
  Scenario: Test web add item to cart
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click login button
    Then user verify see cart icon
    And user click add to cart
    And user click add to cart
    Then verify cart item has "2"

  @web
  Scenario: Test web remove item to cart
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click login button
    Then user verify see cart icon
    And user click add to cart
    And user click add to cart
    Then verify cart item has "2"
    And user click remove item chart
    Then verify cart item has "1"

  @web
  Scenario: Test web sort high to low
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click login button
    Then user verify see cart icon
    And user click sort item high to low

  @web
  Scenario: Test web sort Z to A
    Given user go to login page
    And user input username "standard_user"
    And user input pwd "secret_sauce"
    And user click login button
    Then user verify see cart icon
    And user click sort item Z to A


    @web
    Scenario: Successful login, add product to cart, and proceed to checkout
      Given user go to login page
      And user input username "standard_user"
      And user input pwd "secret_sauce"
      And user click login button
      Then user verify see cart icon
      And user click add to cart
      And user click add to cart
      Then verify cart item has "2"
      And user click cart
      And  user click checkout button

      And user inputs first name
      And  user inputs last name
      And user inputs zipcode
      And user clicks continue
      Then  user should be on the checkout overview page
      And user clicks finish
