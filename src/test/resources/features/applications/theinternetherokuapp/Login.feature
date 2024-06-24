Feature: Login Feature

  @web @positive @regression @smoke
  Scenario Outline: I login to the website with valid userName and valid password
    Given I am on Login page
    When I try to login with userName "<userName>" and password "<password>"
    Then I verify successful login message "<successfulLoginMessage>"
    Examples:
      | userName  | password              | successfulLoginMessage          |
      | tomsmith  | SuperSecretPassword!  | You logged into a secure area!  |

  @web @negative @regression
  Scenario Outline: I login to the website with valid userName and invalid password
    Given I am on Login page
    When I try to login with userName "<userName>" and password "<password>"
    Then I verify invalid password message "<invalidPasswordErrorMessage>"
    Examples:
      | userName  | password        | invalidPasswordErrorMessage   |
      | tomsmith  | invalidpassword |  Your password is invalid!    |

  @web @negative @regression
  Scenario Outline: I login to the website with invalid userName and valid password
    Given I am on Login page
    When I try to login with userName "<userName>" and password "<password>"
    Then I verify invalid userName message "<invalidUsernameErrorMessage>"
    Examples:
      | userName          | password              | invalidUsernameErrorMessage   |
      | invalidusername   | SuperSecretPassword!  | Your username is invalid!     |