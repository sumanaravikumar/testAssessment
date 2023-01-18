Feature: All columns of csv file are mandatory

  Scenario: Test should fail when uploaded incorrect csv file
    Given CSV File upload functionality
    When A CSV file is uploaded with lesser number of columns is uploaded
    Then An error should occur in the upload
