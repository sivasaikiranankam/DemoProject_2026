Feature: Login to SauceDemo

  As a store user
  I want to log in with valid credentials
  So that I can view the products page

  @smoke
  Scenario: Successful login with valid credentials
    Given I open the SauceDemo login page
    When I log in with username "standard_user" and password "secret_sauce"
    Then I should see the products page

  @negative
  Scenario: Login fails with an invalid password
    Given I open the SauceDemo login page
    When I log in with username "standard_user" and password "wrong_password"
    Then I should see a login error message
