Feature: Test getting cars

  Scenario:  getting all cars
    Given I send a get request to cars
    When  I parse the response
    Then I get a list of cars
