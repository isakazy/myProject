Feature: testing categories from CashWise

  @getCategories @regression
  Scenario: get all categories
    Given the API endpoint is "https://backend.cashwise.us/api/myaccount/categories/income"
    When a GET request is sent
    Then the response status code should be 200

