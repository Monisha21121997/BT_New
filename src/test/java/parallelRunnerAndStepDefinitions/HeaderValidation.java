package parallelRunnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePage;

/**
 * Step Definition file for Header Validation.
 * Test Cases are written in HeaderValidation Feature file
 */
public class HeaderValidation {
    TestContext testContext;

    HomePage homePage;

    static Logger log = LogManager.getLogger(HeaderValidation.class);

    public HeaderValidation(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomepage();
    }

    @Then("^Global Nav should be visible$")
    public void global_nav_should_be_visible() {
        homePage.isNavContainerVisible();
    }

    @And("^Bihar Tourism Logo should be visible$")
    public void bihar_tourism_logo_should_be_visible() {
        homePage.isLogoVisible();
    }

    @And("^There should be 5 Links available in the Global Nav Level 1 menu$")
    public void there_should_be_5_links_available_in_the_global_nav_level_1_menu() {
        homePage.isHeaderLinksDisplayed();
    }
}
