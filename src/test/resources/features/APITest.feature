Feature: API TESTING

  @API
  Scenario: Test GET to an endpoint
    Given I send a GET request to the endpoint
    Then I get a 200 status code