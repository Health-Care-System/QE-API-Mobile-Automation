Feature: Product

  @CreateProduct
  Scenario: POST - As a user i have be able to create new product
    Given I set create product API endpoint
    When I send POST HTTP request for create product with valid request body
    Then I receive HTTP response status code 200 OK

  @CreateProduct
  Scenario: POST - As a user i should be failed to create new product with empty name
    Given I set create product API endpoint
    When I send POST HTTP request for create product with invalid request body that empty name
    Then I receive HTTP response status code 400 Bad Request

  @CreateProduct
  Scenario: POST - As a user i should be failed to create new product with the name is numeric
    Given I set create product API endpoint
    When I send POST HTTP request for create product with invalid request body that name is numeric
    Then I receive HTTP response status code 400 Bad Request

  @CreateProduct
  Scenario: POST - As a user i should be failed to create new product with the price is alphabetical
    Given I set create product API endpoint
    When I send POST HTTP request for create product with invalid request body that price is alphabetical
    Then I receive HTTP response status code 400 Bad Request

  @CreateProduct
  Scenario: POST - As a user i should be failed to create new product with the categories is alphabetical
    Given I set create product API endpoint
    When I send POST HTTP request for create product with invalid request body that categories is alphabetical
    Then I receive HTTP response status code 400 Bad Request

  @CreateProduct
  Scenario: POST - As a user i have be able to create new product with multiple category
    Given I set create product API endpoint
    When I send POST HTTP request for create product with multiple categories
    Then I receive HTTP response status code 200 OK

  @CreateProduct
  Scenario: DELETE - As a user i should be failed to create new product with invalid HTTP method
    Given I set create product API endpoint
    When I send DELETE HTTP request for create product with valid request body
    Then I receive HTTP response status code 405 Method Not Allowed

  @GetAllProduct
  Scenario: GET - As a user i have be able to get all products
    Given I set get all products API endpoint
    When I send GET HTTP request for get all products
    Then I receive HTTP response status code 200 OK

  @GetAllProduct
  Scenario: GET - As a user i should be failed to get all products  with invalid HTTP method
    Given I set get all products API endpoint
    When I send POST HTTP request for get all products
    Then I receive HTTP response status code 400 Bad Request

  @GetAllProduct
  Scenario: GET - As a user i should be failed to get all products with invalid API endpoint
    Given I set invalid get all products API endpoint
    When I send GET HTTP request for invalid get all products API endpoint
    Then I receive HTTP response status code 404 Not Found

  @GetProductByID
  Scenario: GET - As a user i have be able to get product by ID with valid product ID
    Given I set get product by ID API endpoint
    When I send GET HTTP request for get product by ID
    Then I receive HTTP response status code 200 OK

  @GetProductByID
  Scenario: POST - As a user i should be failed to get product by ID with invalid HTTP method
    Given I set get product by ID API endpoint
    When I send POST HTTP request for get product by ID
    Then I receive HTTP response status code 405 Method Not Allowed

  @GetProductByID
  Scenario: GET - As a user i should be failed to get product by ID with non existence ID
    Given I set get product by ID API endpoint with non existence ID
    When I send GET HTTP request for get product by non existence ID
    Then I receive HTTP response status code 404 Not Found

  @GetProductByID
  Scenario: GET - As a user i should be failed to get product by ID with invalid API endpoint
    Given I set invalid get product by ID API endpoint
    When I send GET HTTP request for invalid get product by ID
    Then I receive HTTP response status code 400 Bad Request

  @GetProductByID
  Scenario: GET - As a user i should be failed to get product by ID with the product ID is exceed
    Given I set get product by ID API endpoint with ID is exceeding the limit
    When I send GET HTTP request for get product by ID is exceeding the limit
    Then I receive HTTP response status code 500 Internal Server Error

  @DeleteProduct
  Scenario: DELETE - As a user i have be able to delete product with valid product ID
    Given I set delete product API endpoint
    When I send DELETE HTTP request for delete product with valid product ID
    Then I receive HTTP response status code 200 OK

  @DeleteProduct
  Scenario: DELETE - As a user i should be failed to delete product with the product ID is exceed
    Given I set delete product API endpoint with exceed ID
    When I send DELETE HTTP request for delete product with exceed ID
    Then I receive HTTP response status code 500 Internal Server Error

  @DeleteProduct
  Scenario: POST - As a user i should be failed to delete product with invalid HTTP method
    Given I set delete product API endpoint
    When I send POST HTTP request for delete product with valid product ID
    Then I receive HTTP response status code 405 Method Not Allowed

  @DeleteProduct
  Scenario: DELETE - As a user i should be failed to delete product with invalid API endpoint
    Given I set invalid delete product API endpoint
    When I send DELETE HTTP request to invalid delete product endpoint
    Then I receive HTTP response status code 400 Bad Request

  @CreateProductRatings
  Scenario: POST - As a user i have be able to asign product ratings with valid product ID and valid rating count
    Given I set asign product rating API endpoint
    When I send POST HTTP request for asign product rating with valid request body
    Then I receive HTTP response status code 200 OK

  @CreateProductRatings
  Scenario: POST - As a user i should be failed to asign product ratings with invalid product ID and valid rating count
    Given I set asign product rating API endpoint with invalid ID
    When I send POST HTTP request for asign product rating with invalid ID
    Then I receive HTTP response status code 500 Internal Server Error

  @CreateProductRatings
  Scenario: DELETE - As a user i should be failed to asign product ratings with invalid HTTP method
    Given I set asign product rating API endpoint
    When I send DELETE HTTP request for asign product rating with valid request body
    Then I receive HTTP response status code 405 Method Not Allowed

  @CreateProductRatings
  Scenario: POST - As a user i should be failed to asign product ratings with invalid API endpoint
    Given I set invalid asign product rating API endpoint
    When I send POST HTTP request for asign product rating to invalid API endpoint
    Then I receive HTTP response status code 404 Not Found

  @GetProductRating
  Scenario: GET - As a user i have be able to get product ratings with valid product ID
    Given I set valid get product rating API endpoint with valid product ID
    When I send GET HTTP request for get product rating with valid product ID
    Then I receive HTTP response status code 200 OK

  @GetProductRating
  Scenario: GET - As a user i should be failed to get product ratings with invalid API endpoint
    Given I set invalid get product rating API endpoint
    When I send GET HTTP request for get product rating with invalid endpoint
    Then I receive HTTP response status code 404 Not Found

  @CreateComment
  Scenario: POST - As a user i have be able to create comment with valid product ID
    Given I set create comment API endpoint
    When I send POST HTTP request for create comment with valid request body
    Then I receive HTTP response status code 200 OK

  @CreateComment
  Scenario: POST - As a user i should be failed to create comment with valid product ID and the content is numeric
    Given I set create comment API endpoint
    When I send POST HTTP request for create comment with invalid request body that content is numeric
    Then I receive HTTP response status code 500 Internal Server Error

  @CreateComment
  Scenario: DELETE - As a user i should be failed to create comment with invalid http method
    Given I set create comment API endpoint
    When I send DELETE HTTP request for create comment with valid request body
    Then I receive HTTP response status code 405 Method Not Allowed

  @CreateComment
  Scenario: POST - As a user i should be failed to create comment with invalid API endpoint
    Given I set invalid create comment API endpoint
    When I send POST HTTP request for create comment with invalid API endpoint
    Then I receive HTTP response status code 404 Not Found

  @GetComment
  Scenario: GET - As a user i have be able to get comment with valid product ID
    Given I set get comment API endpoint
    When I send GET HTTP request for get comment with valid product ID
    And I receive HTTP response status code 200 OK

  @GetComment
  Scenario: GET - As a user i should be failed to get comment with invalid API endpoint
    Given I set invalid get comment API endpoint
    When I send GET HTTP request for invalid get comment
    Then I receive HTTP response status code 404 Not Found

  @GetComment
  Scenario: GET - As a user i should be failed to get comment with invalid product ID
    Given I set get comment API endpoint with invalid product ID
    When I send GET HTTP request for get comment with invalid product ID
    And I receive HTTP response status code 404 Not Found