package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class loginTest {
    TestContext testContext;
    LoginPage loginPage;

    public loginTest(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("User is on BT Homepage")
    public void user_is_on_bt_homepage() {
        loginPage.openHomepageURL();
    }

    @Given("user clicks on the user icon button")
    public void user_clicks_on_the_user_icon_button() {
        loginPage.clickUserIcon();
    }

    @When("Login popup is visible")
    public void login_popup_is_visible() {
        loginPage.isLoginPopupVisible();
    }

    @And("user enters the {string} and {string}")
    public void userEntersTheAnd(String my_username, String my_password) {
        loginPage.enterUsername(my_username);
        loginPage.enterPassword(my_password);
    }

    @When("user clicks on the Sign In button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.clickSigninButton();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        loginPage.isProfileDisplayed();
    }
}
