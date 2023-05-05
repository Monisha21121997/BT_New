package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.time.Duration;

public class loginTest {
    WebDriver driver;
    LoginPage loginPage;
    PageObjectManager pageObjectManager;

    @Given("User is on BT Homepage")
    public void user_is_on_bt_homepage() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
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

    @When("user is able to enter the username")
    public void user_is_able_to_enter_the_username() {
        loginPage.enterUsername();
    }

    @When("user is able to enter the password")
    public void user_is_able_to_enter_the_password() {
        loginPage.enterPassword();
    }

    @When("user clicks on the Sign In button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.clickSigninButton();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        System.out.println("checking the login displayed link");
        loginPage.isProfileDisplayed();
        driver.quit();
    }

}
