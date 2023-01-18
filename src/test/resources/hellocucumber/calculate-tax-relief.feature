Feature: Calculate Tax Relief

  Scenario: Book keeper should be able to calculate the tax relief amount of employees
    Given Book Keeper send all employee information
    When all Calculate Tax Relief api step definitions are implemented
    Then Calculate Tax Relief result