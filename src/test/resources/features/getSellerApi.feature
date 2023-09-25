Feature: get seller and verify the company name

  @getSeller
  Scenario: Hit api and get seller and verify the company name
    Given the API endpoint is "https://backend.cashwise.us/api/myaccount/sellers/88"
    When a GET request is sent
    Then the response status code should be 200
    And the response body should contain "NovoPokrovka"



    @getSeller @getAllSellers
      Scenario: hit the api to retrieve all sellers and verify sellerName is not null
      Given the API endpoint is "https://backend.cashwise.us/api/myaccount/sellers/all"
      When  a GET request is sent
      Then the response status code should be 200
      And verify the sellerName is not null



      @getSeller @getSellerID
        Scenario: retrieve all sellers ID and make sure seller id is not 0
        Given the API endpoint is "https://backend.cashwise.us/api/myaccount/sellers/all"
        When  a GET request is sent
        Then the response status code should be 200
        And verify the sellerID is not null


        @getSeller @PostSeller
          Scenario: post a seller with name Elnura
          Given the API endpoint is "https://backend.cashwise.us/api/myaccount/sellers"
          When a POST request is sent
          Then response status code must be 201

          @getSeller @VerifyName
            Scenario: retrieve all sellers and verify Elnura is in the list
            Given the API endpoint is "https://backend.cashwise.us/api/myaccount/sellers/all"
            When a GET request is sent
            Then verify seller name "Elnura Alinova" is in the list


            @getSeller @validateEmail
              Scenario: retrieve all sellers and validate all seller email end with .com
              Given the API endpoint is "https://backend.cashwise.us/api/myaccount/sellers/all"
              When a GET request is sent
              Then verify sellers email end with "com"


