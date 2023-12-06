Feature: Doctors
  As a user
  I want to access doctors page
  So that I can see a list of active doctors


  @GetAllAvailableDoctors-056
  Scenario: Verify send GET request to get all available doctors endpoint
    Given I set get all available doctors API endpoint
    When I send GET HTTP request for get all available doctors
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Data Dokter Berhasil Diambil

  @GetAllAvailableDoctors-057
  Scenario: Verify send POST request to get all available doctors endpoint
    Given I set get all available doctors API endpoint
    When I send POST HTTP request for get all available doctors
    Then I receive HTTP response status code 405 Method Not Allowed


  @GetDoctorsBySpecialization-058
  Scenario: Verify send GET request to get all doctors based on specialization endpoint
    Given I set get doctors by specialization API endpoint with valid specialization name
    When I send GET HTTP request for get all available doctors by valid specialization name
    Then I receive HTTP response status code 200 OK
    And I receive valid message that data successfully retrieved

  @GetDoctorsBySpecialization-059
  Scenario: Verify send GET request to get all doctors based on specialization endpoint with invalid specialization name
    Given I set get doctors by specialization API endpoint with invalid specialization name
    When I send GET HTTP request for get all available doctors by invalid specialization name
    Then I receive HTTP response status code 404 Not Found
    And I receive valid message that data not found

  @GetDoctorsBySpecialization-060
  Scenario: Verify send POST request to get all doctors based on specialization endpoint
    Given I set get doctors by specialization API endpoint with valid specialization name
    When I send POST HTTP request for get all available doctors by valid specialization name
    Then I receive HTTP response status code 405 Method Not Allowed