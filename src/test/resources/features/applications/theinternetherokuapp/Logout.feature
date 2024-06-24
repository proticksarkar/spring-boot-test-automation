Feature: Logout Feature

  Background: I have successfully logged in to the website
    Given I login to the website using username and password and verify successful login
      | userName  | password              | successfulLoginMessage          |
      | tomsmith  | SuperSecretPassword!  | You logged into a secure area!  |

  @web @positive @regression @smoke
  Scenario Outline: I login to the website with valid userName and valid password, and logout
    Given I am on Secure Area page
    When I try to logout of the website
    Then I verify successful logout message "<successfulLogoutMessage>"
    Examples:
      | successfulLogoutMessage             |
      | You logged out of the secure area!  |