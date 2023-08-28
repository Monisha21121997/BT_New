@Sitemap
  Feature: Validate Sitemap links
    Description: To validate that all sitemap links navigate correctly and there's no broken link

  Scenario: Validate that the Sitemap links are functional
    Given User is on the Sitemap "https://bt-stage.axeno.co/en/sitemap" page
    Then All links available in the Sitemap should be functional