Feature: Login to HealthCare App

  Background: user navigates to the Healthcare app and then to the login page
  Given user is on the homepage of the portal
  When user navigates to the login page
  Then user should see the Login header


  Scenario: verify user can login with valid credentials

    When user logins with the "<email>", "<password>"
    Then user should be logged in successfully
      | email         | password     |
      | hani@mail.com | Pass1234     |


  Scenario: verify user can not login with invalid password

    When user logins with the "<email>", "<password>"
    Then user should see an error message stating username/password incorrect
      | email         | password     |
      | hani@mail.com | 1234     |


  Scenario: verify user can not login with invalid credentials

    When user logins with the "<email>", "<password>"
    Then user should see an error message stating username/password incorrect
      | email         | password     |
      | abc.com       | Pass1234     |


  Scenario: verify user can navigate to register page from login page

    When user navigates to the register page
    Then user should see the Register header