Feature: Register and Login
  As a user
  I want to register and login
  So that i can access all website feature

  Scenario: POST - As a user i want to successfully register new account
    Given I set register API endpoint
    When I send POST HTTP request for register
    Then I receive HTTP response status code 200 OK

  Scenario: POST - As a user i want to successfully login to my account
    Given I set login API endpoint
    When I send POST HTTP request for login
    Then I receive HTTP response status code 200 OK

  Scenario: GET - As a user i want to get my user information
    Given I set user information API endpoint
    When I send GET HTTP request for user information
    Then I receive HTTP response status code 200 OK
