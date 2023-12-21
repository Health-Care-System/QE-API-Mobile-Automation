Feature: Profiles
  As a user
  I want to access my profile
  So that I can see and update my profile

#  @LoginFirst
#  Scenario: Verify send POST request to login first before update profiles
#    Given I set login user API endpoint before update
#    When I send POST HTTP request for login with valid request body before update profiles
#    Then I receive HTTP response status code 200 OK
#    And I receive valid message that Login Successfull

  @UpdateProfile-045
  Scenario: Verify send PUT request to update user with valid full name, email, password, image url, gender, birthdate, blood type, height, and weight
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with valid request body
    Then I receive HTTP response status code 200 OK
    And I receive valid message that User Updated Data Successful

  @UpdateProfile-046
  Scenario: Verify send PUT request to update user with invalid email format (without "@")
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with invalid email format
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed on Email Validation

  @UpdateProfile-047
  Scenario: Verify send PUT request to update user with name  is exceeding the limit (30)
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with the name is exceed
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed on Max Validation

  @UpdateProfile-048
  Scenario: Verify send PUT request to update user with invalid gender
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with invalid gender
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Invalid Input Gender Data

  @UpdateProfile-049
  Scenario: Verify send PUT request to update user with invalid blood type
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with invalid blood type
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Invalid Input Blood Type Data

  @UpdateProfile-050
  Scenario: Verify send PUT request to update user with invalid height
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with invalid height
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Invalid Input Update Data

  @UpdateProfile-051
  Scenario: Verify send PUT request to update user with invalid weight
    Given I set update user profile API endpoint
    When I send PUT HTTP request for update user profile with invalid weight
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Invalid Input Update Data

  @UpdateProfile-053
  Scenario: Verify send GET request to get user profile endpoint  with valid user ID
    Given I set get user profile API endpoint
    When I send GET HTTP request for get user profile with valid token
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Users Data Successfully Retrieved


