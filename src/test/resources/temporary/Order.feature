Feature: Order

  @CreateOrder
  Scenario: POST - As a user i have be able to create order with valid product ID and quantity
    Given I set create order API endpoint
    When I send POST HTTP request for create order with valid product_id and quantity
    Then I receive HTTP response status code 200 OK

  @CreateOrder
  Scenario: POST - As a user should be failed to create order with invalid product ID and valid quantity
    Given I set create order API endpoint
    When I send POST HTTP request for create order with invalid product_id and valid quantity
    Then I receive HTTP response status code 200 OK

  @CreateOrder
  Scenario: POST - As a user should be failed to create order with valid product ID and invalid quantity
    Given I set create order API endpoint
    When I send POST HTTP request for create order with valid product_id and invalid quantity
    Then I receive HTTP response status code 200 OK

  @CreateOrder
  Scenario: POST - As a user should be failed to create order with empty product ID and valid quantity
    Given I set create order API endpoint
    When I send POST HTTP request for create order with empty product_id and valid quantity
    Then I receive HTTP response status code 200 OK

  @CreateOrder
  Scenario: POST - As a user should be failed to create order with valid product ID and empty quantity
    Given I set create order API endpoint
    When I send POST HTTP request for create order with valid product_id and empty quantity
    Then I receive HTTP response status code 200 OK

  @CreateOrder
  Scenario: DELETE - As a user should be failed to create order with invalid HTTP method
    Given I set create order API endpoint
    When I send DELETE HTTP request for create order with valid product_id and valid quantity
    Then I receive HTTP response status code 405 Method Not Allowed

  @CreateOrder
  Scenario: POST - As a user should be failed to create order with invalid API endpoint
    Given I set invalid create order API endpoint
    When I send POST HTTP request for create order with valid product_id and valid quantity
    Then I receive HTTP response status code 404 Not Found



  @GetOrder
  Scenario: GET - As a user i have be able to get all orders
    Given I set get all orders API endpoint
    When I send GET HTTP request for get all orders
    Then I receive HTTP response status code 200 OK

  @GetOrder
  Scenario: GET - As a user i should be failed to get order with invalid API endpoint
    Given I set invalid get all orders API endpoint
    When I send GET HTTP request for invalid get all orders
    Then I receive HTTP response status code 404 Not Found

  @GetOrder
  Scenario: POST - As a user i should be failed to get all order with invalid HTTP method
    Given I set get all orders API endpoint
    When I send POST HTTP request for get all orders
    Then I receive HTTP response status code 400 Bad Request

  @GetOrderByID
  Scenario: GET - As a user i have be able to get order by ID
    Given I set get orders by ID API endpoint
    When I send GET HTTP request for get orders by ID
    Then I receive HTTP response status code 200 OK

  @GetOrderByID
  Scenario: GET - As a user i should be failed to get order by ID with invalid ID
    Given I set get orders by ID API endpoint with invalid ID
    When I send GET HTTP request for get orders by ID with invalid ID
    Then I receive HTTP response status code 404 Not Found

  @GetOrderByID
  Scenario: GET - As a user i should be failed to get order by ID with the ID is exceed
    Given I set get orders by ID API endpoint with ID exceeding the limit
    When I send GET HTTP request for get orders by ID with ID exceeding the limit
    Then I receive HTTP response status code 404 Not Found

  @GetOrderByID
  Scenario: DELETE - As a user i should be failed to get order by ID with invalid HTTP method
    Given I set get orders by ID API endpoint
    When I send DELETE HTTP request for get orders by ID
    Then I receive HTTP response status code 405 Method Not Allowed