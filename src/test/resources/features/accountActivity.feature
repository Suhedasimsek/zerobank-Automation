Feature: Account Activity

Scenario: User should be able to see the account activity

Given User should be on the login page
When User should input username "username" and password "password"
And User should navigate to "Account Activity"
And User should see the "Savings" as default type
And User should see the following Accounts
|Savings    |
|Checking   |
|Savings    |
|Loan       |
|Credit Card|
|Brokerage  |

And User should see the following options

|Date        |
|Description |
|Deposit     |
|Withdrawal  |