Feature: users
  User can CRUD about users
  Scenario: insert a new user
    Given a new user to insert
    When user insert a new user
    Then user is able to retreive inserted user later