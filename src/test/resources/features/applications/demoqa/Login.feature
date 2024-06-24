#Feature: Login Feature
#
#  @positive @regression @smoke
#  Scenario Outline: I login to the website with valid userName and valid password
#    Given I am on the Login page
#    When I try to login with userName "<userName>" and password "<password>"
#    Then I verify login is successful "<userName>"
#    Examples:
#      | userName    | password      |
#      | qatestuser  | Password@123  |
#
#  @negative @regression
#  Scenario Outline: I login to the website with invalid userName and invalid password
#    Given I am on the Login page
#    When I try to login with userName "<userName>" and password "<password>"
#    Then I verify invalid user credentials message "<invalidUserCredentialsErrorMessage>"
#    Examples:
#      | userName        | password        | invalidUserCredentialsErrorMessage  |
#      | invalidusername | invalidpassword | Invalid username or password!       |