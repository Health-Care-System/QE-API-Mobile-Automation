Feature: Articles
  As a user
  I want to get access health article page
  So that I can read about health information


  @GetAllHealthArticles-035
  Scenario: Verify send GET request to get all health articles endpoint
    Given I set get all health articles API endpoint
    When I send GET HTTP request for get all health articles
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data article

  @GetAllHealthArticles-036
  Scenario: Verify send POST request to get all health articles endpoint
    Given I set get all health articles API endpoint
    When I send POST HTTP request for get all health articles
    Then I receive HTTP response status code 405 Method Not Allowed



  @GetHealthArticlesByID-037
  Scenario: Verify send GET request to get health article by ID endpoint with valid article ID
    Given I set get health article by ID API endpoint with valid ID
    When I send GET HTTP request for get health article by valid ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data

  @GetHealthArticlesByID-038
  Scenario: Verify send GET request to get health article by ID endpoint with invalid article ID
    Given I set get health article by invalid ID API endpoint with invalid ID
    When I send GET HTTP request for get health article by invalid ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that invalid id param

  @GetHealthArticlesByID-039
  Scenario: Verify send GET request to get health article by ID endpoint with non existing article ID
    Given I set get health article by ID API endpoint with non existing ID
    When I send GET HTTP request for get health article non existing ID
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that not found

  @GetHealthArticlesByID-040
  Scenario: Verify send POST request to get health article by ID endpoint with valid article ID
    Given I set get health article by ID API endpoint with valid ID
    When I send POST HTTP request for get health article by valid ID
    Then I receive HTTP response status code 405 Method Not Allowed


  @GetHealthArticlesByTitle-041
  Scenario: Verify send GET request to get health article by ID endpoint with valid article title
    Given I set get health article by title API endpoint with valid title
    When I send GET HTTP request for get health article by valid title
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data article

  @GetHealthArticlesByTitle-042
  Scenario: Verify send GET request to get health article by ID endpoint with invalid article title
    Given I set get health article by title API endpoint with invalid title
    When I send GET HTTP request for get health article by invalid title
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that not found

  @GetHealthArticlesByTitle-043
  Scenario: Verify send GET request to get health article by ID endpoint with empty parameter
    Given I set get health article by title API endpoint with valid title
    When I send GET HTTP request for get health article by valid title
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that title query param required

  @GetHealthArticlesByTitle-044
  Scenario: Verify send POST request to get health article by ID endpoint with valid article title
    Given I set get health article by title API endpoint with valid title
    When I send POST HTTP request for get health article by valid title
    Then I receive HTTP response status code 405 Method Not Allowed