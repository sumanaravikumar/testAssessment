Feature: Cash is dispensed

  Scenario: Governor should be able to dispense cash successfully 
    Given A browser
    When Dispense now button gets clicked
    Then Cash dispensed page opens shows up
    
