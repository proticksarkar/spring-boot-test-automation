Feature: Open New Window Feature

  @web @positive @regression @smoke
  Scenario Outline: I open a new window and switch to it
    Given I am on Open New Window page
    When I open a new window and switch to it
    Then I verify the page title "<newWindowPageTitle>"
    When I switch back to parent window
    Then I verify the page title "<parentWindowPageTitle>"
    Examples:
      | newWindowPageTitle   | parentWindowPageTitle  |
      | New Window           | The Internet           |