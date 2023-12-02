Feature: Medicines
  As a user
  I want to get medicine information
  So that I can choose medicine to buy


  @GetALlMedicine-026
  Scenario: Verify send GET request to get all medicines endpoint
    Given I set get all medicines API endpoint
    When I send GET HTTP request for get all medicines
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Medicines Data Successfully Retrieved

  @GetALlMedicine-027
  Scenario: Verify send POST request to get all medicines endpoint
    Given I set get all medicines API endpoint
    When I send POST HTTP request for get all medicines
    Then I receive HTTP response status code 405 Method Not Allowed


  @GetMedicineByName-028
  Scenario: Verify send GET request to get medicines by name endpoint with valid name
    Given I set get medicine by name API endpoint with valid name
    When I send GET HTTP request for get medicine by name
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Medicines Data Successfully Retrieved

  @GetMedicineByName-029
  Scenario: Verify send GET request to get medicines by name endpoint with invalid name
    Given I set get medicine by name API endpoint with invalid name
    When I send GET HTTP request for get medicine by invalid name
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that Medicine Not Found

  @GetMedicineByName-030
  Scenario: Verify send POST request to get medicines by name endpoint with valid name
    Given I set get medicine by name API endpoint with valid name
    When I send POST HTTP request for get medicine by name
    Then I receive HTTP response status code 405 Method Not Allowed


  @GetMedicineByID-031
  Scenario: Verify send GET request to get medicine by ID endpoint with valid medicine ID
    Given I set get medicine by ID API endpoint with valid ID
    When I send GET HTTP request for get medicine by ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Medicines Data Successfully Retrieved

  @GetMedicineByID-032
  Scenario: Verify send GET request to get medicine by ID endpoint with invalid medicine ID
    Given I set get medicine by invalid ID API endpoint with invalid ID
    When I send GET HTTP request for get medicine by invalid ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Invalid Medicine ID

  @GetMedicineByID-033
  Scenario: Verify send GET request to get medicine by ID endpoint with non existing medicine ID
    Given I set get medicine by invalid ID API endpoint with non existing ID
    When I send GET HTTP request for get medicine by non existing ID
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that Failed to Retrieve Medicine Data

  @GetMedicineByID-034
  Scenario: Verify send POST request to get medicine by ID endpoint with valid medicineID
    Given I set get medicine by ID API endpoint with valid ID
    When I send POST HTTP request for get medicine by ID
    Then I receive HTTP response status code 405 Method Not Allowed