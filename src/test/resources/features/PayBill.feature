@smoke @payBill
Feature: Add new payee under pay bills

  Background: Login
    Given the user is logged in

  Scenario Outline: Pay Bills
    Given the user clicks on "Add New Payee" link on the "Pay Bills" page
    Given Pay Bills page should have the title "Zero - Pay Bills"
    When user selects "<payee>" under the Make payments feature for "payee"
    And user selects "<account>" under the Make payments feature for "account"
    And user types "<amount>" under the Make payments feature for "amount"
    And user types "<date>" under the Make payments feature for "date"
    And user types "<description>" under the Make payments feature for "description"
    And user clicks to pay button
    When user completes a successful Pay operation, "The payment was successfully submitted." should be displayed
    Examples:
      | payee           | account     | amount | date       | description         |
      | Sprint          | Savings     | 100    | 2021-07-01 | groceries           |
      | Bank of America | Checking    | 1000   | 2021-07-02 | rent                |
      | Apple           | Credit Card | 750    | 2021-07-03 | credit card payment |
      | Wells Fargo     | Loan        | 2500   | 2021-07-04 | mortgage            |


   # When user tries to make a payment without entering the amount or date, Please fill out this field message! should be displayed.

  Scenario Outline: Add a new payee
    Given Add New Payee tab
    And user enters "<Payee Name>" in Payee Name text box
    And user enters "<Payee Address>" in Payee Address text box
    And user enters "<Account>" in Account text box
    And user enters "<Payee details>" in Payee details text box
    And user clicks to add button
    Then message "was successfully created" should be displayed
    Examples:
      | Payee Name                              | Payee Address                       | Account  | Payee details |
      | The Law Offices of Hyde, Price & Sharks | 100 Same st, Town, USA, 10001       | Checking | account       |
      | Kimukin Family Co.                      | 100 Main st, Pittsburgh, USA, 10001 | Loan     | loan          |




  # Amount field should not accept alphabetical or special characters. Date field should not accept alphabetical characters.
 # NOTE: . For the date input field you can just use sendKeys. No need to click on the date navigator.
