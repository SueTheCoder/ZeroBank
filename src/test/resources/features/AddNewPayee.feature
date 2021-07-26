Feature: Add new payee under pay bills

  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100	Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed


  Scenario: Pay Bills
  Given Account Activity page should have the title "Zero - Pay Bills"
    When user completes a successful Pay operation, "The payment was successfully submitted." should be displayed.
    When user tries to make a payment without entering the amount or date, Please fill out this field message! should be displayed.
  # Amount field should not accept alphabetical or special characters. Date field should not accept alphabetical characters.
 # NOTE: . For the date input field you can just use sendKeys. No need to click on the date navigator.
