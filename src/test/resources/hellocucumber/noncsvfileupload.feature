Feature: A non csv file upload

  Scenario: Test should fail when non csv file is uploaded from browser
    Given File upload functionality
    When A non csv file is uploaded
    Then An error should occur
