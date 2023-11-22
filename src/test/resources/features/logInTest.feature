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


          @login @logAllUsers
            Scenario Outline: user logs in multiple valid usernames and verifies all the users are logged in
            Given user is on the log in page
            And user clicks on the sing in button
            Then the sing in pop up must be displayed
            When when user inputs a valid username "<username>"
            And user inputs a valid password "<password>"
            And user clicks on the singTWo in button
            Then verify the user was logged in

            Examples:
              | username          | password        |
              | isakazy@gmail.com | isakazyamanbaev |
              | ashot@gmail.com   | 12345678        |
              | lapuh@gmail.com   | 12345678        |
              | sancho@gmail.com  | 12345678        |


  @login @loginMultipleInvalidAccounts
              Scenario Outline: user tries to log in using invalid passwords and emails
              Given user is on the log in page
              And user clicks on the sing in button
              Then the sing in pop up must be displayed
              When when user inputs an invalid username "<username>"
              And user inputs a invalid password "<password>"
              And user clicks on the singTWo in button
              Then verify "Wrong password or email" is displayed

              Examples:
                | username              | password   |
                | feafwea@gmail.com     | sfsdfafaf  |
                | sdaggd@gmail.com      | sdfafa     |
                | wtrt@gmail.com        | gzegaewrew |
                | gdsfhjo@gmail.com     | agdsgag    |
                | gadsgdhfgfh@gmail.com | agfhshdhsj |








