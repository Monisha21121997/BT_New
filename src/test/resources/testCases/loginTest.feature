Feature: Validate Login Feature on Dev Site
  Description: To validate that the user is able to login into BT Dev Site


  Scenario: User is trying to login using correct credentials
    Given User is on BT Homepage
    And user clicks on the user icon button
    When Login popup is visible
    And user is able to enter the username
    And user is able to enter the password
    And user clicks on the Sign In button
    Then user should be logged in
