Feature: Register new user

  Background: user navigates to the Healthcare app and then to the Register page
    Given user is on the homepage of the portal

    When user navigates to the Register page
    Then user should see the Register header


  Scenario: verify user can register themself

    When user provides their <firstname>, <lastname>, <email> and <password>
    | firstname | lastname | email          | password  |
    | Hani      | Chatha   | mani@gmail.com | Pass1234@ |
    Then user should be registered successfully


  Scenario: verify that already registered user can not re-register

    When user provides their <firstname>, <lastname>, <email> and <password>
      | firstname | lastname | email          | password  |
      | Hani      | Chatha   | hani@mail.com | Pass1234@ |
    Then user should see an error message stating that user already exists


  Scenario: verify that user can not register with simple(non-alphanumeric) password

    When user provides their <firstname>, <lastname>, <email> and <password>
      | firstname | lastname | email          | password  |
      | Jon       | Abc      | jon@gmail.com  | 12345678 |
    Then user should see an error message stating alphanumeric password is required


  Scenario: verify user can not proceed without filling mandatory fields

    When user clicks on register button
    Then user should see an error message stating that mandatory fields are missing

  Scenario: verify user can navigate to login page from Register page

    When user navigates to the login page from register page
    Then user should see the Login header