Feature: Login

  Scenario: User should be able to login with valid credentials
    Given User should be on the login page
    When User should input username "username" and password "password"
    And User should navigate to "Account Summary"
    Then "Account Summary" page should be displayed


  Scenario Outline: User should not able to login with invalid credentials

    When User should input usenameInfo "<usernameInput>" and passwordInfo "<passwordInput>"
    Then  Error message "Login and/or password are wrong." should be displayed

    Examples:
      | usernameInput | passwordInput |
      | username | wrong |
      | wrong    | password |
      | username |          |
      |          | password |

