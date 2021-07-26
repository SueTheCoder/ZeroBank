


Feature: Find Transactions in Account Activity

  Background: Login
    Given the user is logged in
    Given the user clicks on "Find Transactions" link on the "Account Activity" page

  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And clicks find button
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks find button
    Then results table should only show No result.
    When the user enters description "OFFICE"
    And clicks find button
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "OFFICE"

  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks find button
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date

  Scenario: Search amounts range
    When the user enters amounts range from "599" to "1100"
    And clicks find button
    Then results table should only show transactions amounts between "599" to "1100"
    And the results table should be sorted by deposit amount

  Scenario: Type
    When user selects dropdown Type "Any"
    And clicks find button
    Then results table should show at least one result under Deposit   //div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]
    Then results table should show at least one result under Withdrawal   //div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]
    When user selects dropdown Type  "Deposit"
    And clicks find button
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal  //div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]
    When user selects dropdown Type  "Withdrawal"
    And clicks find button
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit  //div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]
