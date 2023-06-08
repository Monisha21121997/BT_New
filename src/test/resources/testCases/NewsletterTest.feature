Feature: Validate the Newsletter Feature
  Description: To validate that the user is able to subscribe the newsletter

  @Sanity
  Scenario: Validate the behaviour when already subscribed email ID is used to subscribe Newsletter
    Given User is on BT Homepage
    When Newsletter component is visible
    And User enters the Name as "TestUser" & Email as "btqa1@yopmail.com" information
    And Clicks on Subscribe button
    Then "This email id is already subscribed" Error message should appear