Feature: Login to HealthCare App

  Background: user navigates to the Healthcare app and then to the login page
  Given user is on the homepage of the portal
  When user navigates to the login page
  Then user should see the Login header


  Scenario: verify user can login with valid credentials

    When user logins with the <email>, <password>
      | email         | password     |
      | hani@mail.com | Pass1234@     |
    Then user should be logged in successfully

  Scenario: verify user can not login with invalid password

    When user logins with the <email>, <password>
      | email         | password     |
      | hani@mail.com | 1234         |
    Then user should see an error message stating password is incorrect


  Scenario: verify user can not login with invalid credentials

    When user logins with the <email>, <password>
      | email         | password     |
      | abc.com       | Pass1234     |
    Then user should see an error message stating username is incorrect


  Scenario: verify user can navigate to register page from login page

    When user navigates from login to the Register page
    Then user should see the Register header