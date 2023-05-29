package parallelRunnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LoginPage;

public class LoginTest {

    TestContext testContext;
    LoginPage loginPage;

    static Logger log = LogManager.getLogger(LoginTest.class);

    public LoginTest(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("User is on BT Homepage")
    public void user_is_on_bt_homepage() {
        loginPage.openHomepageURL();
        log.info("============== User launch the Bihar Tourism Homepage ==============\n");
    }

    @Given("user clicks on the user icon button")
    public void user_clicks_on_the_user_icon_button() {
        loginPage.clickUserIcon();
        log.info("============== User clicks on the user icon ==============\n");
    }

    @When("Login popup is visible")
    public void login_popup_is_visible() {
        loginPage.isLoginPopupVisible();
        log.info("============== Login Form is shown to the user ==============\n");
    }

    @And("user enters the {string} and {string}")
    public void userEntersTheAnd(String my_username, String my_password) {
        loginPage.enterUsername(my_username);
        loginPage.enterPassword(my_password);
        log.info(
                "======= User enters the username & password as provided in the feature file =======\n");
    }

    @When("user clicks on the Sign In button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.clickSigninButton();
        log.info(
                "======= User enters the username & password as provided in the feature file =======\n");
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        loginPage.isProfileDisplayed();
        log.info("======= User is logged in =======\n");
    }
}
