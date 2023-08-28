package RunnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePageObjects;

public class NewsLetterValidation {

  TestContext testContext;

  HomePageObjects homePageObjects;

  static Logger log = LogManager.getLogger(HeaderValidation.class);

  public NewsLetterValidation(TestContext context) {
    testContext = context;
    homePageObjects = testContext.getPageObjectManager().getHomepageObjects();
  }

  @When("Newsletter component is visible")
  public void newsletter_component_is_visible() {
    log.info("-------------------------------------------------------------------------------");
    log.info("<------- Checking NewsLetter Component ------->");
    assertThat(homePageObjects.getNewsLetterComponent()).isTrue();
    log.info("----- Newsletter Component is visible -----");
    log.info("---------------------------------------------------------------------------\n\n");
  }

  @When("User enters the Name as {string} & Email as {string} information")
  public void user_enters_the_name_as_email_as_information(String myEmail, String myPassword) {
    log.info("-------------------------------------------------------------------------------");
    log.info("<------- Entering Email Address and Password ------->");
    homePageObjects.enterNewsletterEmail(myEmail);
    homePageObjects.enterNewsletterPassword(myPassword);
    log.info("<------- Entered Email Address and Password ------->");
    log.info("---------------------------------------------------------------------------\n\n");
  }

  @When("Clicks on Subscribe button")
  public void clicks_on_subscribe_button() {
    log.info("-------------------------------------------------------------------------------");
    log.info("<------- Submitting NewsLetter Request ------->");
    homePageObjects.submitNewsletterRequest();
    log.info("<------- NewsLetter Request Submitted ------->");
    log.info("---------------------------------------------------------------------------\n\n");
  }

  @Then("{string} Error message should appear")
  public void error_message_should_appear(String expectedResponse) {
    log.info("-------------------------------------------------------------------------------");
    log.info("<------- Checking Error Message ------->");
    assertThat(homePageObjects.getNewsletterResponse()).isEqualTo(expectedResponse);
    log.info("::::: Error Message is correct ::::: ");
    log.info("---------------------------------------------------------------------------\n\n");
  }
}
