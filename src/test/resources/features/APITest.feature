Feature: API TESTING

  Scenario: Test GET to an endpoint
    Given I send a GET request to the endpoint
    Then I get a list with  10 users