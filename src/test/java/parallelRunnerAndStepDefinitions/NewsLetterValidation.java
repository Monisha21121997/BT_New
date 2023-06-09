package parallelRunnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePage;

public class NewsLetterValidation {
    TestContext testContext;

    HomePage homePage;

    static Logger log = LogManager.getLogger(HeaderValidation.class);

    public NewsLetterValidation(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomepage();
    }

    @When("Newsletter component is visible")
    public void newsletter_component_is_visible() {
        homePage.getNewsLetterComponent();
    }

    @When("User enters the Name as {string} & Email as {string} information")
    public void user_enters_the_name_as_email_as_information(String myEmail, String myPassword) {
        homePage.enterNewsletterEmail(myEmail);
        homePage.enterNewsletterPassword(myPassword);
    }

    @When("Clicks on Subscribe button")
    public void clicks_on_subscribe_button() {
        homePage.submitNewsletterRequest();
    }

    @Then("{string} Error message should appear")
    public void error_message_should_appear(String expectedResponse) {
        log.info(":::::<<Newsletter Response is>>::::: " +
                assertThat(homePage.getNewsletterResponse()).isEqualTo(expectedResponse));
    }
}
