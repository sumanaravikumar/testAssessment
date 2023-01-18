Feature: Cash is dispensed by the governer

 Scenario: Cash Dispensed success message should be displayed on browser
    Given A browser and technical challenge application UI
    When Dispense now button is clicked
    Then Cash dispensed page opens up