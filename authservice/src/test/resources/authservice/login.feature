Feature: login
  User who provides valid credentials will receive a token
  Scenario: user provides credentials
    Given a user with invalid credentials
    When user login
    Then user is returned without token but invalid credentials feedback
  Scenario: user provides valid credentials
    Given a user with valid credentials
    When user login
    Then user is returned with a token
  Scenario: user does log out without having been logged in
    Given a user without token
    When user does logout
    Then nothing happens
  Scenario: user does log out having been logged in
    Given a user with token
    When user does logout
    Then user's token is put into invalid tokens set