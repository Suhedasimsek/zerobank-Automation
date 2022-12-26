Feature: Add new payee under pay bills

  Background:
    Given User should be on the login page
    When User should input username "username" and password "password"
    And User should navigate to "Pay Bills"



  Scenario: Add a new payee
  And User should input the pay requirements
  Then "The payment was successfully submitted." message should be displayed on page





  Scenario Outline: User should not be able to complete pay operation with invalid credentials
    And User should not complete pay operation by using invalid "<Amount>", "<Date>","<Description>"
    Then "The payment was successfully submitted." message should not be displayed on page
    Examples:

      | Amount    | Date     | Description  |
      | someMoney | December | Good Payment |
      | ??3000    |          | Good Payment |


  @wip
    Scenario:
    Given Add New Payee tab
  And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee details | XYZ account |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed