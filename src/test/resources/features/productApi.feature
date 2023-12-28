Feature: scenarios for testing cashWise products


  @products @getAllProducts @regression
  Scenario: get all products and validate status code must ne 200
    Given the api endpoint is "https://backend.cashwise.us/api/myaccount/products"
    When a GET request is sent
    Then the response status code should be 200

