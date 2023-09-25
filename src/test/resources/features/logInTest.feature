Feature: log in functionality test

  @login @success
  Scenario: successful log in
    Given user is on the log in page
    When user clicks on the sing in button
    Then the sing in pop up must be displayed
    When when user inputs a valid username "isakazy@gmail.com"
    And user inputs a valid password "isakazyamanbaev"
    And user clicks on the singTWo in button
    Then user must be logged in

    @login @invalidPassword
    Scenario: invalid password attempt
      Given user is on the log in page
      When user clicks on the sing in button
      Then the sing in pop up must be displayed
      When when user inputs an invalid username "email"
      And user inputs a invalid password "password"
      And user clicks on the singTWo in button
      Then wrong email or password text must be displayed

      @login @invalidEmail
      Scenario: invalid email login attempt
        Given user is on the log in page
        When user clicks on the sing in button
        Then the sing in pop up must be displayed
        When when user inputs an invalid username "email"
        And user inputs a invalid password "password"
        And user clicks on the singTWo in button
        Then wrong email or password text must be displayed


        @login @logout
          Scenario:  user logs out
          Given user in on the dashboard
          And user clicks on his name
          When user selects log out
          Then log out alert must be displayed
          When user clicks on log out alert
          Then  verify the user was logged out







