Feature: Transaction Doctor
  As a user
  I want to buy a consultation service with a doctor
  So that I got a solution to my complaint

#  @CreateTransactionDoctor-061
#  Scenario: Verify send POST request to create doctor transaction endpoint with valid doctor ID, payment method, and payment confirmation
#    Given I set create doctor transaction API endpoint with valid doctor ID
#    When I send POST HTTP request for create doctor transaction with valid request body
#    Then I receive HTTP response status code 201 Created
#    And I receive valid message that doctor transaction created successful
#
#  @CreateTransactionDoctor-062
#  Scenario: Verify send POST request to create doctor transaction endpoint with invalid doctor ID
#    Given I set create doctor transaction API endpoint with invalid doctor ID
#    When I send POST HTTP request for create doctor transaction to invalid doctor ID endpoint
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that invalid doctor id
#
#  @CreateTransactionDoctor-063
#  Scenario: Verify send POST request to create doctor transaction with non existing doctor ID
#    Given I set create doctor transaction API endpoint with non existing doctor ID
#    When I send POST HTTP request for create doctor transaction to non exist doctor ID
#    Then I receive HTTP response status code 500 Internal Server Error
#    And I receive valid message that doctor failed to retrieve doctor data
#
#  @CreateTransactionDoctor-064
#  Scenario: Verify send POST request to create doctor transaction with empty doctor ID
#    Given I set create doctor transaction API endpoint with empty doctor ID
#    When I send POST HTTP request for create doctor transaction to empty doctor ID
#    Then I receive HTTP response status code 405 Method Not Allowed
#
#  @CreateTransactionDoctor-065
#  Scenario: Verify send POST request to create doctor transaction with empty payment method
#    Given I set create doctor transaction API endpoint with valid doctor ID
#    When I send POST HTTP request for create doctor transaction with empty payment method
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that Failed on Payment Method Validation
#
#  @CreateTransactionDoctor-066
#  Scenario: Verify send POST request to create doctor transaction with invalid payment method
#    Given I set create doctor transaction API endpoint with valid doctor ID
#    When I send POST HTTP request for create doctor transaction with invalid payment method
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that failed to create doctor transaction
#
#  @CreateTransactionDoctor-067
#  Scenario: Verify send POST request to create doctor transaction with empty payment confirmation
#    Given I set create doctor transaction API endpoint with valid doctor ID
#    When I send POST HTTP request for create doctor transaction with empty payment confirmation
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that payment confirmation file is required
#
#  @CreateTransactionDoctor-068
#  Scenario: Verify send POST request to create doctor transaction with invalid file for payment confirmation
#    Given I set create doctor transaction API endpoint with valid doctor ID
#    When I send POST HTTP request for create doctor transaction with invalid payment confirmation
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that invalid image file format


  @GetAllTransactionDoctor-069
  Scenario: Verify send GET request to get all doctor transactions endpoint
    Given I set get all doctor transactions API endpoint
    When I send GET HTTP request for get all doctor transactions
    Then I receive HTTP response status code 200 OK
    And I receive valid message that doctor transaction data successfully retrieved

  @GetAllTransactionDoctor-070
  Scenario: Verify send POST request to get all doctor transactions endpoint
    Given I set get all doctor transactions API endpoint
    When I send POST HTTP request for get all doctor transactions
    Then I receive HTTP response status code 405 Method Not Allowed


  @GetTransactionDoctorByStatus-071
  Scenario: Verify send GET request to get doctor transaction by status success
    Given I set get doctor transactions API endpoint with status success
    When I send GET HTTP request for get doctor transactions with status success
    Then I receive HTTP response status code 200 OK
    And I receive valid message that doctor transaction data successfully retrieved

  @GetTransactionDoctorByStatus-072
  Scenario: Verify send GET request to get doctor transaction by status pending
    Given I set get doctor transactions API endpoint with status pending
    When I send GET HTTP request for get doctor transactions with status pending
    Then I receive HTTP response status code 200 OK
    And I receive valid message that doctor transaction data successfully retrieved

  @GetTransactionDoctorByStatus-073
  Scenario: Verify send GET request to get doctor transaction by status cancelled
    Given I set get doctor transactions API endpoint with status cancelled
    When I send GET HTTP request for get doctor transactions with status cancelled
    Then I receive HTTP response status code 200 OK
    And I receive valid message that doctor transaction data successfully retrieved

  @GetTransactionDoctorByStatus-074
  Scenario: Verify send POST request to get doctor transaction by status endpoint
    Given I set get doctor transactions API endpoint with status pending
    When I send POST HTTP request for get doctor transactions with status pending
    Then I receive HTTP response status code 405 Method Not Allowed


  @GetTransactionDoctorByID-075
  Scenario: Verify send GET request to get doctor transaction by valid ID
    Given I set get doctor transactions by valid ID API endpoint
    When I send GET HTTP request for get doctor transactions by valid ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that doctor transaction data successfully retrieved

  @GetTransactionDoctorByID-076
  Scenario: Verify send GET request to get doctor transaction by invalid ID
    Given I set get doctor transactions by invalid ID API endpoint
    When I send GET HTTP request for get doctor transactions by invalid ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that invalid transaction id

  @GetTransactionDoctorByID-077
  Scenario: Verify send GET request to get doctor transaction by non existing ID
    Given I set get doctor transactions by non exist ID API endpoint
    When I send GET HTTP request for get doctor transactions by non exist ID
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that failed to retrieve doctor transaction data

  @GetTransactionDoctorByID-078
  Scenario: Verify send POST request to get doctor transaction by valid ID
    Given I set get doctor transactions by valid ID API endpoint
    When I send POST HTTP request for get doctor transactions by valid ID
    Then I receive HTTP response status code 400 Bad Request


