Feature: API TESTING

  @API
  Scenario: Test GET to an endpoint
    Given I send a GET request to the "https://api.github.com" URI
    Then I get a 200 status code

  @API
  Scenario: Validate users amount
    Given I send a GET request to the "https://jsonplaceholder.typicode.com" URI
    Then I validate there are 10 items on the "/users" enpoint

  @API
  Scenario: Validate user value is present
    Given I send a GET request to the "https://jsonplaceholder.typicode.com" URI
    Then I validate there is a value: "Bilardo" in the response at "/users" endpoint

  @API
  Scenario: Validate user street is present
    Given I send a GET request to the "https://jsonplaceholder.typicode.com" URI
    Then I can validate the nested: "Dayna Park" on the response at "/users" endpoint
    