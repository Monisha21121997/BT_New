Feature: Validate Login Feature on Dev Site
  Description: To validate that the user is able to login into BT Dev Site


  Scenario Outline: User is trying to login using correct credentials
    Given User is on BT Homepage
    And user clicks on the user icon button
    When Login popup is visible
    And user enters the "<username>" and "<password>"
    And user clicks on the Sign In button
    Then user should be logged in


    Examples:
      | username          | password     |
      | btqa1@yopmail.com | Passtest123$ |
#      | btqa2@yopmail.com | Passtest123$ |
