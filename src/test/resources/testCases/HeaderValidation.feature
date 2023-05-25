Feature: Validate Header Links on the site
  Description: To validate that the Header Links are available as per the design

  Scenario: Validate the Header Logo and Level 1 Header Links
    Given User is on BT Homepage
    Then Global Nav should be visible
    And Bihar Tourism Logo should be visible
    And There should be 5 Links available in the Global Nav Level 1 menu
