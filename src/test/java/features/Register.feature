Feature: Register new user

  Background: navigate to url and goto register page
  Given user is on the homepage of HealthCare App
  Then user will be on the homepage
  When user clicks on the register link on the navbar
  Then user will be navigated to the register page


  Scenario: verify a new user registration

    When user enters firstname lastname email password
    | firstname | lastname | email          | password  |
    | Hani      | Chatha   | hani@gmail.com | Pass1234@ |
    And user clicks on register button
    Then user will be registered successfully

  Scenario: verify already registered user can not re-register

    When user enters firstname lastname email password
      | firstname | lastname | email          | password  |
      | Hani      | Chatha   | hani@gmail.com | Pass1234@ |
    And user clicks on register button
    Then user will be shown an error message stating user already exists

  Scenario: verify user cannot register with simple password

    When user enters firstname lastname email password
      | firstname | lastname | email          | password  |
      | Jon       | Abc      | jon@gmail.com  | 12345678 |
    And user clicks on register button
    Then user will be shown an error message stating alphanumeric password is required

  Scenario: verify user registration without providing mandatory fields

    When user clicks on register button
    Then user will be shown an error message stating that mandatory fields are missing

  Scenario: verify user can navigate to login page

    When user clicks on the login link
    Then user will be navigated to the Login page