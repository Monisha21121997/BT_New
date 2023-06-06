package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

/**
 * Page Object Manager is to create the page's object.
 * And also to make sure that the same object should not be created again and again.
 * But to use a single object for all the step definition files.
 */
public class PageObjectManager {

  private WebDriver driver;
  private LoginPage loginPage;

  private HomePage homePage;

  public PageObjectManager(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage getLoginPage() {
    return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
  }

  public HomePage getHomepage(){
    return (homePage == null) ? homePage = new HomePage(driver) : homePage;
  }
}
