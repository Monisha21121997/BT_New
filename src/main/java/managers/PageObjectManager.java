package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SitemapPageObjects;

/**
 * Page Object Manager is to create the page's object. And also to make sure that the same object
 * should not be created again and again. But to use a single object for all the step definition
 * files.
 */
public class PageObjectManager {

  private WebDriver driver;
  private LoginPageObjects loginPageObjects;
  private HomePageObjects homePageObjects;
  private SitemapPageObjects sitemapPageObjects;

  public PageObjectManager(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPageObjects getLoginPageObjects() {
    return (loginPageObjects
        == null) ? loginPageObjects = new LoginPageObjects(driver) : loginPageObjects;
  }

  public HomePageObjects getHomepageObjects() {
    return (homePageObjects
        == null) ? homePageObjects = new HomePageObjects(driver) : homePageObjects;
  }

  public SitemapPageObjects getSitemapPageObjects(){
    return (sitemapPageObjects == null) ? sitemapPageObjects = new SitemapPageObjects(driver) : sitemapPageObjects;
  }
}
