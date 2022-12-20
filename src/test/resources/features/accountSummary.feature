Feature: Account Summary

  Scenario: The user should be able to see the account details
    Given User should be on the login page
    When User should input username "username" and password "password"
    And User should navigate to "http://zero.webappsecurity.com/bank/account-summary.html"
    And "Account Summary" page should be displayed
    Then User should see the following Accounts Types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    Then Credit Accounts table should have following columns
      | Account     |
      | Credit Card |
      | Balance     |