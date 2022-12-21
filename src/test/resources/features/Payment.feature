Feature: Add new payee under pay bills
@wip
  Scenario: Add a new payee
  Given User should be on the login page
  When User should input username "username" and password "password"
  And User should navigate to "Pay Bills"
  Given Add New Payee tab
  And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee details | XYZ account |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed