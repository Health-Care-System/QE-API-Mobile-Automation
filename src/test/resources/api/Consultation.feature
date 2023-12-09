Feature: Transaction Medicine
  As a user
  I want to create room chat
  So that I can sent complaint message to the doctor

  @CreateRoomChat-115
  Scenario: Verify send POST to create room chat by valid doctor transaction ID
    Given I set valid create room chat by valid doctor transaction ID API endpoint
    When I send POST HTTP request for create room chat by valid doctor transaction ID
    Then I receive HTTP response status code 201 Created
    And I receive valid message that roomchat created successful

  @CreateRoomChat-116
  Scenario: Verify send POST to create room chat by invalid doctor transaction ID
    Given I set valid create room chat by invalid doctor transaction ID API endpoint
    When I send POST HTTP request for create room chat by invalid doctor transaction ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that failed create room chat by invalid doctor transaction ID

  @CreateRoomChat-117
  Scenario: Verify send POST to create room chat by non existing doctor transaction ID
    Given I set valid create room chat by non existing doctor transaction ID API endpoint
    When I send POST HTTP request for create room chat by non existing doctor transaction ID
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that failed create room chat by non existing doctor transaction ID

  @CreateRoomChat-118
  Scenario: Verify send POST to create room chat by doctor transaction ID with the status is still pending
    Given I set valid create room chat by doctor transaction ID with status pending API endpoint
    When I send POST HTTP request for create room chat by doctor transaction ID with status pending
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that failed to retrieve doctor transaction data for create room chat

  @CreateRoomChat-119
  Scenario: Verify send POST to create room chat by doctor transaction ID with the status is cancelled
    Given I set valid create room chat by doctor transaction ID with status cancelled API endpoint
    When I send POST HTTP request for create room chat by doctor transaction ID with status cancelled
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that failed to retrieve doctor transaction data for create room chat

  @CreateRoomChat-120
  Scenario: Verify send POST to create room chat by doctor transaction ID that has been used
    Given I set valid create room chat by valid doctor transaction ID API endpoint
    When I send POST HTTP request for create room chat by valid doctor transaction ID
    Then I receive HTTP response status code 409 Conflict
    And I receive valid message that failed create room chat by already used doctor transaction ID



  @CreateComplaintMessage-121
  Scenario: Verify send POST to create complaint message by valid room chat ID and valid request body
    Given I set valid create complaint message by valid room chat ID API endpoint
    When I send POST HTTP request for create complaint message by valid room chat ID
    Then I receive HTTP response status code 201 Created
    And I receive valid message that complaint message successful send

#  @CreateComplaintMessage-122
#  Scenario: Verify send POST to create complaint message by valid room chat ID and sent image file
#    Given I set valid create complaint message by valid room chat ID API endpoint
#    When I send POST HTTP request for create complaint message by valid room chat ID and sent image file
#    Then I receive HTTP response status code 201 Created
#    And I receive valid message that complaint message successful send

#  @CreateComplaintMessage-123
#  Scenario: Verify send POST to create complaint message by valid room chat ID and sent audio message
#    Given I set valid create complaint message by valid room chat ID API endpoint
#    When I send POST HTTP request for create complaint message by valid room chat ID and sent audio file
#    Then I receive HTTP response status code 201 Created
#    And I receive valid message that complaint message successful send

  @CreateComplaintMessage-124
  Scenario: Verify send POST to create complaint message by invalid room chat ID and valid request body
    Given I set valid create complaint message by invalid room chat ID API endpoint
    When I send POST HTTP request for create complaint message by invalid room chat ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that invalid roomchat id

  @CreateComplaintMessage-125
  Scenario: Verify send POST to create complaint message by non existing room chat ID and valid request body
    Given I set valid create complaint message by non existing room chat ID API endpoint
    When I send POST HTTP request for create complaint message by non existing room chat ID
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that failed to retrieve roomchat data

#  @CreateComplaintMessage-126
#  Scenario: Verify send POST to create complaint message by valid room chat ID and sent invalid file format for image field
#    Given I set valid create complaint message by valid room chat ID API endpoint
#    When I send POST HTTP request for create complaint message by valid room chat ID and sent invalid file format for image field
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that invalid image file format for consultation message

#  @CreateComplaintMessage-127
#  Scenario: Verify send POST to create complaint message by valid room chat ID and sent exceed maximum image size
#    Given I set valid create complaint message by valid room chat ID API endpoint
#    When I send POST HTTP request for create complaint message by valid room chat ID and sent exceed image zize
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that file size exceeds the maximum allowed size

#  @CreateComplaintMessage-128
#  Scenario: Verify send POST to create complaint message by valid room chat ID and sent invalid file format for audio field
#    Given I set valid create complaint message by valid room chat ID API endpoint
#    When I send POST HTTP request for create complaint message by valid room chat ID and sent invalid file format for audio field
#    Then I receive HTTP response status code 400 Bad Request
#    And I receive valid message that invalid audio file format

  @CreateComplaintMessage-129
  Scenario: Verify send POST to create complaint message by valid room chat ID and sent exceed maximum audio size
    Given I set valid create complaint message by valid room chat ID API endpoint
    When I send POST HTTP request for create complaint message by valid room chat ID and sent exceed audio zize
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that file size exceeds the maximum allowed size


  @GetRoomChat-130
  Scenario: Verify send GET to get room chat by valid ID
    Given I set get room chat by valid ID API endpoint
    When I send GET HTTP request for get room chat by valid ID
    Then I receive HTTP response status code 200 OK
    And I receive valid message that roomchat data successfully retrieved

  @GetRoomChat-131
  Scenario: Verify send GET to get room chat by invalid ID
    Given I set get room chat by invalid ID API endpoint
    When I send GET HTTP request for get room chat by invalid ID
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that invalid roomchat id

  @GetRoomChat-132
  Scenario: Verify send GET to get room chat by non existing ID
    Given I set get room chat by non existing ID API endpoint
    When I send GET HTTP request for get room chat by non existing ID
    Then I receive HTTP response status code 500 Internal Server Error
    And I receive valid message that failed to retrieve roomchat data
