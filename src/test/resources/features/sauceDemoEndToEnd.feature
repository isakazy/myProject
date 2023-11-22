Feature:  End to End Test for SauceDemo.com

  @sauceDemoE2E
  Scenario: user logs in to the sauce demo and successfully places the order.
  Given user is on the login page of sauceDemo
    When user provides a valid userName
    And user provides a valid password
    And user clicks on the login button
    Then verify the user was logged in to sauceDemo
    When user navigates to T-shirt
    Then verify the user was redirected to T-shirt page
    And  user clicks on the add to card button
    Then verify the item was added to card
    When user navigates to card
    Then verify the user was redirected to the card
    And verify the item is in the cart
    When user clicks on the check out button
    Then verify the user was redirected to check our info page
    And user provides his valid first name
    And user provides his valid last name
    And user provide his valid zip code
    When user clicks on the continue button
    Then verify the user was redirected to checkout overview page
    And verify the item is displayed
    And verify the payment info is displayed
    And verify hte shipping info is displayed
    And verify the  prise is displayed
    And verify the total price is displayed
    When user click on finish button
    Then verify the user was redirected to the login page
    Then verify the checkout was complete



