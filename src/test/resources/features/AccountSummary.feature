@AccountSummary
Feature: Account summary page

  Scenario: Account Summary page info
    Given the user is logged in
    Given Account Summary page should have the title "Zero - Account Summary"
    And Account Summary page should have to following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table must have columns:
      | Account     |
      | Credit Card |
      | Balance     |