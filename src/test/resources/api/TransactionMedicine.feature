Feature: Transaction Medicine
  As a user
  I want to access medicine page
  So that I can buy medicine


  @CreateMedicineTransaction-079
  Scenario: Verify send POST request to create medicine transaction endpoint with valid request body
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with valid request body
    Then I receive HTTP response status code 201 Created
    And I receive valid message that successfully created medicine transaction

  @CreateMedicineTransaction-080
  Scenario: Verify send POST request to create medicine transaction endpoint with multiple diferent product
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with multiple diferent product
    Then I receive HTTP response status code 201 Created
    And I receive valid message that successfully created medicine transaction

  @CreateMedicineTransaction-081
  Scenario: Verify send POST request to create medicine transaction endpoint with empty name
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with empty name
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with empty name

  @CreateMedicineTransaction-082
  Scenario: Verify send POST request to create medicine transaction endpoint with empty address
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with empty address
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with empty address

  @CreateMedicineTransaction-083
  Scenario: Verify send POST request to create medicine transaction endpoint with empty phone number
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with empty phone number
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with empty phone number

  @CreateMedicineTransaction-084
  Scenario: Verify send POST request to create medicine transaction endpoint with empty payment method
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with empty payment method
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with empty payment method

  @CreateMedicineTransaction-085
  Scenario: Verify send POST request to create medicine transaction endpoint with non exist medicine ID
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with non exist medicine ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with non exist medicine ID

  @CreateMedicineTransaction-086
  Scenario: Verify send POST request to create medicine transaction endpoint with invalid medicine id
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with invalid medicine ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with invalid medicine ID

  @CreateMedicineTransaction-087
  Scenario: Verify send POST request to create medicine transaction endpoint with empty quantity
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with empty quantity
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with empty quantity

  @CreateMedicineTransaction-088
  Scenario: Verify send POST request to create medicine transaction endpoint with invalid quantity
    Given I set valid create medicine transaction API endpoint
    When I send POST HTTP request for create medicine transaction with invalid quantity
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create medicine transaction with invalid quantity

  @CreateMedicineTransaction-089
  Scenario: Verify send DELETE request to create medicine transaction endpoint with valid request body
    Given I set valid create medicine transaction API endpoint
    When I send DELETE HTTP request for create medicine transaction with valid request body
    Then I receive HTTP response status code 405 Method Not Allowed



  @GetAllMedicineTransaction-090
  Scenario: Verify send GET request to get all medicine transactions endpoint
    Given I set valid get all medicine transactions API endpoint
    When I send GET HTTP request for get all medicine transactions
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data medicine transactions

  @GetAllMedicineTransaction-091
  Scenario: Verify send POST request to get all medicine transactions endpoint
    Given I set valid get all medicine transactions API endpoint
    When I send POST HTTP request for get all medicine transactions
    Then I receive HTTP response status code 400 Bad Request



  @GetMedicineTransactionByStatus-092
  Scenario: Verify send GET request to get medicine transaction by status endpoint (belum dibayar)
    Given I set valid get medicine transactions by status belum dibayar API endpoint
    When I send GET HTTP request for get medicine transactions by status belum dibayar
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data medicine transactions

  @GetMedicineTransactionByStatus-093
  Scenario: Verify send GET request to ge medicine transaction by status endpoint (sudah dibayar)
    Given I set valid get medicine transactions by status sudah dibayar API endpoint
    When I send GET HTTP request for get medicine transactions by status sudah dibayar
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data medicine transactions

  @GetMedicineTransactionByStatus-094
  Scenario: Verify send GET request to get medicine transaction by status endpoint with invalid status
    Given I set valid get medicine transactions by invalid API endpoint
    When I send GET HTTP request for get medicine transactions by invalid status
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that failed get medicine transaction with invalid status

  @GetMedicineTransactionByStatus-095
  Scenario: Verify send DELETE request to get transaction by status endpoint
    Given I set valid get medicine transactions by status belum dibayar API endpoint
    When I send DELETE HTTP request for get medicine transactions by status belum dibayar
    Then I receive HTTP response status code 405 Method Not Allowed



  @GetMedicineTransactionByID-096
  Scenario: Verify send GET request to get medicine transactions by ID endpoint
    Given I set valid get medicine transactions by ID API endpoint
    When I send GET HTTP request for get medicine transactions by ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data medicine transaction

  @GetMedicineTransactionByID-097
  Scenario: Verify send GET request to get medicine transactions by invalid ID endpoint
    Given I set get medicine transactions by invalid ID API endpoint
    When I send GET HTTP request for get medicine transactions by invalid ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed to get medicine transaction by invalid ID

  @GetMedicineTransactionByID-098
  Scenario: Verify send GET request to get medicine transactions by non existing ID endpoint
    Given I set get medicine transactions by non existing ID API endpoint
    When I send GET HTTP request for get medicine transactions by non existing ID
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that failed to get medicine transaction by non existing ID



  @DeleteMedicineTransaction-099
  Scenario: Verify send DELETE request to delete medicine transactions by valid ID endpoint
    Given I set valid delete medicine transactions API endpoint with valid ID
    When I send DELETE HTTP request for delete medicine transactions with valid ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully deleted medicine transaction

  @DeleteMedicineTransaction-100
  Scenario: Verify send DELETE request to delete medicine transactions by invalid ID endpoint
    Given I set valid delete medicine transactions API endpoint with invalid ID
    When I send DELETE HTTP request for delete medicine transactions with invalid ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed to delete medicine transaction with invalid ID

  @DeleteMedicineTransaction-101
  Scenario: Verify send DELETE request to delete medicine transactions by non existing ID endpoint
    Given I set valid delete medicine transactions API endpoint with non existing ID
    When I send DELETE HTTP request for delete medicine transactions with non existing ID
    Then I receive HTTP response status code 403 Forbidden
    And I receive valid message that failed to delete medicine transaction with non existing ID



  @CreateCheckout-102
  Scenario: Verify send POST request to create checkout with valid request body and medicine transaction ID
    Given I set valid create checkout API endpoint with valid medicine transaction ID
    When I send POST HTTP request for create checkout with valid medicine transaction ID
    Then I receive HTTP response status code 201 Created
    And I receive valid message that successfully created checkout

  @CreateCheckout-103
  Scenario: Verify send POST request to create checkout with valid request body and invalid medicine transaction ID
    Given I set valid create checkout API endpoint with invalid medicine transaction ID
    When I send POST HTTP request for create checkout with invalid medicine transaction ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed to create checkout with invalid medicine transaction

  @CreateCheckout-104
  Scenario: Verify send POST request to create checkout with valid request body and non existing medicine transaction ID
    Given I set valid create checkout API endpoint with non esxisting medicine transaction ID
    When I send POST HTTP request for create checkout with non existing medicine transaction ID
    Then I receive HTTP response status code 403 Forbidden
    And I receive valid message that failed to create checkout with non existing medicine transaction ID

  @CreateCheckout-105
  Scenario: Verify send POST request to create checkout with invalid payment confirmation and valid medicine transaction ID
    Given I set valid create checkout API endpoint with valid medicine transaction ID
    When I send POST HTTP request for create checkout with valid medicine transaction ID and invalid payment confirmation
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed to create checkout with invalid payment confirmation

  @CreateCheckout-106
  Scenario: Verify send POST request to create checkout with empty payment confirmation and valid medicine transaction ID
    Given I set valid create checkout API endpoint with valid medicine transaction ID
    When I send POST HTTP request for create checkout with valid medicine transaction ID and empty payment confirmation
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed to create checkout with empty payment confirmation



  @GetCheckout-107
  Scenario: Verify send GET request to get all checkout endpoint
    Given I set valid get all checkout API endpoint
    When I send GET HTTP request for get all checkout
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data checkouts



  @GetCheckoutByStatus-108
  Scenario: Verify send GET request to get checkout by status pending endpoint
    Given I set valid get checkout by status pending API endpoint
    When I send GET HTTP request for get checkout by status pending
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data checkouts

  @GetCheckoutByStatus-109
  Scenario: Verify send GET request to get checkout by status success endpoint
    Given I set valid get checkout by status success API endpoint
    When I send GET HTTP request for get checkout by status success
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data checkouts

  @GetCheckoutByStatus-110
  Scenario: Verify send GET request to get checkout by status cancelled endpoint
    Given I set valid get checkout by status cancelled API endpoint
    When I send GET HTTP request for get checkout by status cancelled
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data checkouts

  @GetCheckoutByStatus-111
  Scenario: Verify send GET request to get checkout by invalid status endpoint
    Given I set valid get checkout by invalid status API endpoint
    When I send GET HTTP request for get checkout by invalid status
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that failed get checkout with invalid status


  @GetCheckoutByID-112
  Scenario: Verify send GET request to get checkout by ID endpoint
    Given I set valid get checkout by valid ID API endpoint
    When I send GET HTTP request for get checkout by valid ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data checkout

  @GetCheckoutByID-113
  Scenario: Verify send GET request to get checkout by invalid ID endpoint
    Given I set valid get checkout by invalid ID API endpoint
    When I send GET HTTP request for get checkout by invalid ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed to get checkout by invalid ID

  @GetCheckoutByID-114
  Scenario: Verify send GET request to get checkout by non existing ID endpoint
    Given I set valid get checkout by non existing ID API endpoint
    When I send GET HTTP request for get checkout by non existing ID
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that failed to get checkout by non existing ID