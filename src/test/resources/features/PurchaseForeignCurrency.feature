@smoke @purchaseCurrency
Feature: Purchase Foreign Currency

  Background: Login
    Given the user is logged in
    Given the user clicks on Purchase Foreign Currency link on the Pay Bills page

  Scenario: Available currencies
    Then following currencies should be available
      | Select One            |
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error alert should be displayed

  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error alert should be displayed
