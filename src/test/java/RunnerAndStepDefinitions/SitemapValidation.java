package RunnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.SitemapPageObjects;

/**
 * Step Definition File for Sitemap Validation, Test Cases are written in SitemapValidation Feature file
 */
public class SitemapValidation {
  TestContext testContext;
  SitemapPageObjects sitemapPageObjects;
  static Logger log = LogManager.getLogger(SitemapValidation.class);

  public SitemapValidation(TestContext context){
    testContext = context;
    sitemapPageObjects = testContext.getPageObjectManager().getSitemapPageObjects();
  }


  @Given("User is on the Sitemap {string} page")
  public void userIsOnTheSitemapPage(String pageURL) {
    sitemapPageObjects.openSitemapPage(pageURL);
  }

  @Then("All links available in the Sitemap should be functional")
  public void allLinksAvailableInTheSitemapShouldBeFunctional() {
    sitemapPageObjects.validateLinks();
  }
}
