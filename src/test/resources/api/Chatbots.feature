Feature: Chatbots
  As a user
  I want to use chatbot
  So that I can get information about healthcare


  @Chatbots-019
  Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Pembayaran Obat)
    Given I set customer service bot API endpoint
    When I send POST HTTP request for customer service with the request is Cara Pembayaran Obat
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data recommendation

  @Chatbots-020
  Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Beri Rating Dokter)
    Given I set customer service bot API endpoint
    When I send POST HTTP request for customer service with the request is Cara Beri Rating Dokter
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data recommendation

  @Chatbots-021
  Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Lihat Riwayat Konsultasi)
    Given I set customer service bot API endpoint
    When I send POST HTTP request for customer service with the request is Cara Lihat Riwayat Konsultasi
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data recommendation

#  @Chatbots-022
#  Scenario: Verify send POST request to chatbot endpoint with valid request (Get Health Advice and Diet Recommendation)
#    Given I set chat bot API endpoint
#    When I send POST HTTP request for chat bot with the request is Health Advice
#    Then I receive HTTP response status code 200 OK
#    And I receive valid message that successfully get data recommendation

  @Chatbots-023
  Scenario: Verify send POST request to chatbot endpoint with empty request
    Given I set chat bot API endpoint
    When I send POST HTTP request for chat bot with empty request
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed on Request Validation

#  @Chatbots-024
#  Scenario: Verify send POST request to chatbot endpoint with invalid request
#    Given I set chat bot API endpoint
#    When I send POST HTTP request for chat bot with the request is asking for medicine prescription
#    Then I receive HTTP response status code 400 Bad Request
#    Then I receive HTTP response status code 200 OK


  @Chatbots-025
  Scenario: Verify send DELETE request to chatbot endpoint with valid request
    Given I set chat bot API endpoint
    When I send DELETE HTTP request for chat bot with the request is Health Advice
    Then I receive HTTP response status code 405 Method Not Allowed
