Feature: Product Categories

  @CreateCategory
  Scenario: POST - As a user i have be able to create new product category
    Given I set create categories API endpoint
    When I send POST HTTP request for create categories with valid name and description
    Then I receive HTTP response status code 200 OK

  @CreateCategory
  Scenario: POST - As a user i should be failed to create new product category with empty name
    Given I set create categories API endpoint
    When I send POST HTTP request for create categories with invalid request body that empty name
    Then I receive HTTP response status code 500 Internal Server Error

  @CreateCategory
  Scenario: POST - As a user i should be failed to create new product category with the name is numeric
    Given I set create categories API endpoint
    When I send POST HTTP request for create categories with invalid request body that name is numeric
    Then I receive HTTP response status code 400 Bad Request

  @CreateCategory
  Scenario: DELETE - As a user i should be failed to create new product category with invalid HTTP method
    Given I set create categories API endpoint
    When I send DELETE HTTP request for create categories with valid name and description
    Then I receive HTTP response status code 405 Method Not Allowed

  @CreateCategory
  Scenario: POST - As a user i should be failed to create new product category with invalid endpoint
    Given I set invalid create categories API endpoint
    When I send POST HTTP request for create categories with invalid endpoint
    Then I receive HTTP response status code 404 Not Found


  @GetCategory
  Scenario: GET - As a user i have be able to get all product categories
    Given I set get all categories API endpoint
    When I send GET HTTP request for get all categories
    Then I receive HTTP response status code 200 OK

  @GetCategory
  Scenario: DELETE - As a user i should be failed to get all categories with invalid HTTP method
    Given I set get all categories API endpoint
    When I send DELETE HTTP request for get all categories
    Then I receive HTTP response status code 405 Method Not Allowed

  @GetCategory
  Scenario: GET - As a user i should be failed to get all categories with invalid API endpoint
    Given I set invalid get all categories API endpoint
    When I send GET HTTP request for invalid get all categories
    Then I receive HTTP response status code 404 Not Found

#  @GetCategoryByID
#  Scenario: GET - As a user i have be able to get category by ID with valid category ID
#    Given I set get categories by ID API endpoint
#    When I send GET HTTP request for get categories by ID
#    Then I receive HTTP response status code 200 OK

  @GetCategoryByID
  Scenario: GET - As a user i should be failed to get category by ID with invalid ID
    Given I set get categories by ID API endpoint with invalid ID
    When I send GET HTTP request for get categories by invalid ID
    Then I receive HTTP response status code 500 Internal Server Error

  @GetCategoryByID
  Scenario: GET - As a user i should be failed to get category by ID with the ID is exceed
    Given I set get categories by ID API endpoint with ID exceeding the limit
    When I send GET HTTP request for get categories by ID exceeding the limit
    Then I receive HTTP response status code 404 Not Found

  @GetCategoryByID
  Scenario: POST - As a user i should be failed to get category by ID with invalid HTTP method
    Given I set get categories by ID API endpoint
    When I send POST HTTP request for get categories by ID
    Then I receive HTTP response status code 405 Method Not Allowed


  @DeleteCategory
  Scenario: DELETE - As a user i have be able to delete product category with valid product ID
    Given I set delete category ID API endpoint
    When I send DELETE HTTP request for delete category
    Then I receive HTTP response status code 200 OK

  @DeleteCategory
  Scenario: DELETE - As a user i should be failed to delete product category with product ID is exceed
    Given I set delete category API endpoint with ID exceeding the limit
    When I send DELETE HTTP request for delete category by ID exceeding the limit
    Then I receive HTTP response status code 500 Internal Server Error

  @DeleteCategory
  Scenario: DELETE - As a user i should be failed to delete product category with invalid delete category endpoint
    Given I set invalid delete category API endpoint
    When I send DELETE HTTP request for invalid delete category
    Then I receive HTTP response status code 404 Not Found

  @DeleteCategory
  Scenario: POST - As a user i should be failed to delete product category with invalid HTTP method
    Given I set delete category ID API endpoint
    When I send POST HTTP request for delete category
    Then I receive HTTP response status code 404 Not Found