Feature: Register and Login
  As a user
  I want to register and login
  So that i can access all the feature

  @Register-001
  Scenario: Verify send POST request to register user endpoint with valid full name, email, password
    Given I set register user API endpoint
    When I send POST HTTP request for register with valid request body
    Then I receive HTTP response status code 201 Created
    And I receive valid message that Registered Successful

  @Register-005
  Scenario: Verify send POST request to register user endpoint with invalid email format (without "@")
    Given I set register user API endpoint
    When I send POST HTTP request for register with invalid email format
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed on Email Validation

  @Register-006
  Scenario: Verify send POST request to register user endpoint by using the registered email
    Given I set register user API endpoint
    When I send POST HTTP request for register with registered email
    Then I receive HTTP response status code 409 Conflict
    And I receive valid message that Email Already Exist


  @Login-009
  Scenario: Verify send POST request to login user endpoint with valid email, and password
    Given I set login user API endpoint
    When I send POST HTTP request for login with valid request body
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Login Successfull

  @Login-013
  Scenario: Verify send POST request to login user endpoint with unregistered email and valid password
    Given I set login user API endpoint
    When I send POST HTTP request for login with unregistered email
    Then I receive HTTP response status code 401 Unauthorized
    And I receive valid message that Email Not Registered

  @Login-014
  Scenario: Verify send POST request to login user endpoint with invalid email (without "@") and valid password
    Given I set login user API endpoint
    When I send POST HTTP request for login with invalid email format
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed on Email Validation

  @Delete-015
  Scenario: Verify send DELETE request to delete user endpoint with valid login token
    Given I set delete user API endpoint
    When I send DELETE HTTP request for delete user with valid login token
    Then I receive HTTP response status code 200 OK
    And I receive valid message that User Deleted Data Successful