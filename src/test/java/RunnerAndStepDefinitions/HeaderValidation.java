package RunnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePageObjects;

/**
 * Step Definition file for Header Validation. Test Cases are written in HeaderValidation Feature
 * file
 */
public class HeaderValidation {

  TestContext testContext;

  HomePageObjects homePageObjects;

  static Logger log = LogManager.getLogger(HeaderValidation.class);

  public HeaderValidation(TestContext context) {
    testContext = context;
    homePageObjects = testContext.getPageObjectManager().getHomepageObjects();
  }

  @Then("^Global Nav should be visible$")
  public void global_nav_should_be_visible() {
    log.info("-------------------------------------------------------------------");
    log.info("----------- Checking if the Navbar is visible or not -----------");
    if (homePageObjects.isNavContainerVisible()) {
      log.info("<----- Navbar is visible ----->");
    } else {
      log.error("<----- Navbar is not displayed ----->");
      assertThat(homePageObjects.isNavContainerVisible()).isTrue();
    }
    log.info("----------------------------------------------------------------\n\n");
  }

  @And("^Bihar Tourism Logo should be visible$")
  public void bihar_tourism_logo_should_be_visible() {
    log.info("-------------------------------------------------------------------");
    log.info("----------- Checking if the BT Logo is visible or not -----------");
    if (homePageObjects.isLogoVisible()) {
      log.info("----------- BT Logo is visible -----------");
    } else {
      log.error("<----------- BT Logo is not displayed --------->");
      assertThat(homePageObjects.isLogoVisible()).isTrue();
    }
    log.info("----------------------------------------------------------------\n\n");
  }

  @And("^There should be 5 Links available in the Global Nav Level 1 menu$")
  public void there_should_be_5_links_available_in_the_global_nav_level_1_menu() {
    log.info("-------------------------------------------------------------------");
    log.info("----------- Checking if the Nav Links are visible or not -----------");
    assertThat(homePageObjects.isHeaderLinksDisplayed()).isGreaterThanOrEqualTo(5);
    log.info("----------------------------------------------------------------\n\n");
  }
}
