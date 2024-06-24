Feature: Handling Excel data using Poiji

  @nobrowser @excel @regression
  Scenario Outline: Basic Excel Handling - Row Wise [<Scenario>]
    Given User loads excel data and maps it to POJO
    When User selects scenario "<Scenario>" and gets corresponding data
    Then User verifies the fetched data
    Examples:
      | Scenario          |
      | TC1-BasicDataType |