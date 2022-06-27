Feature: User should be able to create and retrieve employee data


  Scenario:  Validate that user is able to create new employee record
    Given I create new employee record
    And I validate the created record
    When I get employee details
    Then I verify "TestData12345" exists in the employee table

  @Sanity
  Scenario: User is able to sum two numbers
    Given I have 9 and 10
    When I add number
    Then I get result

  Scenario: When I get countries , I verify that vietnam exists in the response
    Given I have API headers
      | x-rapidapi-host | restcountries-v1.p.rapidapi.com                    |
      | x-rapidapi-key  | bf96595661mshdcb8f0e0407e3f7p10671djsn30e45bc5d48a |
    When I get countries
    Then I verify Vietnam exists in the response


