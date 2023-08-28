package RunnerAndStepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LoginPageObjects;

/**
 * Step Definition File for Login Validation, Test Cases are written in LoginTest Feature file
 */
public class LoginValidation {

  TestContext testContext;
  LoginPageObjects loginPageObjects;

  static Logger log = LogManager.getLogger(LoginValidation.class);

  public LoginValidation(TestContext context) {
    testContext = context;
    loginPageObjects = testContext.getPageObjectManager().getLoginPageObjects();
  }

  @Given("User is on BT Homepage")
  public void user_is_on_bt_homepage() {
    log.info("-------------------------------------------------------------------");
    log.info("============== Opening the Bihar Tourism Homepage URL ==============");
    loginPageObjects.openHomepageURL();
    log.info("----------- User launched the Bihar Tourism Homepage ------------");
    log.info("-----------------------------------------------------------\n\n");
  }

  @Given("user clicks on the user icon button")
  public void user_clicks_on_the_user_icon_button() {
    log.info("-------------------------------------------------------------------");
    log.info("------------ Clicking the User Icon ------------------");
    loginPageObjects.clickUserIcon();
    log.info("-------------- User clicks on the user icon -----------------------");
    log.info("-----------------------------------------------------------\n\n");
  }

  @When("Login popup is visible")
  public void login_popup_is_visible() {
    log.info("-------------------------------------------------------------------");
    log.info("------------ Checking the Login Form Visibility ------------------");
    assertThat(loginPageObjects.isLoginPopupVisible()).isTrue();
    log.info("------------- Login Form is shown to the user ---------------");
    log.info("-----------------------------------------------------------\n\n");
  }

  @And("user enters the {string} and {string}")
  public void userEntersTheAnd(String my_username, String my_password) {
    log.info("-------------------------------------------------------------------");
    log.info("------------ Entering the UserName and Password ------------------");
    loginPageObjects.enterUsername(my_username);
    loginPageObjects.enterPassword(my_password);
    log.info("------- User enters the username & password ---------");
    log.info("-----------------------------------------------------------\n\n");
  }

  @When("user clicks on the Sign In button")
  public void user_clicks_on_the_sign_in_button() {
    log.info("-------------------------------------------------------------------");
    log.info("------------ Clicking the Signin Button ------------------");
    loginPageObjects.clickSigninButton();
    log.info("-------------- User clicks the Signin Button ------------------");
    log.info("-----------------------------------------------------------\n\n");
  }

  @Then("user should be logged in")
  public void user_should_be_logged_in() {
    log.info("-------------------------------------------------------------------");
    log.info("<---------------- Checking if the user is logged in or not -------------->");
    if (loginPageObjects.profileDisplayed().isDisplayed()) {
      log.info("<-------------- User is logged in -------------->");
      loginPageObjects.profileDisplayed().click();
    } else {
      log.error("<-------------- User is unable to login -------------->");
      assertThat(loginPageObjects.profileDisplayed().isDisplayed()).isTrue();
    }
    log.info("-----------------------------------------------------------\n\n");
  }
}
