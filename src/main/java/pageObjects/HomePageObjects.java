package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;

import java.util.List;

/**
 * This is a Page Repository class using the Selenium Page Factory concept. Page Factory is an
 * inbuilt Page Object Model concept for Selenium WebDriver, and it is very optimized. PageFactory
 * is used to Initialize Elements of a Page class without having to use 'FindElement‘ or
 * ‘FindElements‘. Annotations can be used to supply descriptive names of target objects to improve
 * code readability.
 */
public class HomePageObjects {

  WebDriver driver;
  BrowserActions browserActions;

  //Initializing PageFactory using class Constructor
  public HomePageObjects(WebDriver driver) {
    this.driver = driver;
    browserActions = new BrowserActions(driver);
    PageFactory.initElements(driver, this);
  }
  private static final Logger log = LogManager.getLogger(HomePageObjects.class);

  /**
   * @FindBy Annotation As the name suggest, it helps to find the elements in the page using By
   * strategy. It can accept TagName, PartialLinkText, Name, LinkText, Id, Css, ClassName, XPath as
   * attributes.
   */

  //Finding the Page WebElements
  @FindBy(xpath = "//nav[contains(@class,'navbar')]")
  private WebElement nav_container;
  @FindBy(xpath = "//a[@class='logo__href white__logo']")
  private WebElement bt_logo;

  @FindBy(xpath = "//ul[contains(@class,'navbar-nav')]//li[contains(@class,'mx-2 nav-item')]")
  private List<WebElement> nav_items;

  @FindBy(xpath = "//div[contains(@class,'bhr__news__letter__heading')]")
  private WebElement newsLetter;

  @FindBy(xpath = "//div[contains(@class,'bhr__news__letter__heading')]//following::input[1]")
  private WebElement newsletter_Email;

  @FindBy(xpath = "//div[contains(@class,'bhr__news__letter__heading')]//following::input[2]")
  private WebElement newsletter_Password;

  @FindBy(xpath = "//button[contains(@class,'bhr__news__mail__btn')]")
  private WebElement newsletter_Submit;

  @FindBy(xpath = "//div[contains(@class,'newsletter-response')]")
  private WebElement newsletter_response;

  //Public getter methods

  public boolean isNavContainerVisible() {
    return nav_container.isDisplayed();
  }

  public boolean isLogoVisible() {
   return bt_logo.isDisplayed();
  }

  public int isHeaderLinksDisplayed() {
    if (nav_items.size() >= 5) {
      log.info(
          "----------- Total " + nav_items.size() + " links are visible in Header -----------");
      for (WebElement e : nav_items) {
        log.info(e.getText());
      }
      log.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    } else {
      log.error("<----------- Nav links are not authored --------->");
    }
    return nav_items.size();
  }

  public boolean getNewsLetterComponent() {
    Actions actions = new Actions(driver);
    actions.scrollToElement(newsLetter);
    return newsLetter.isDisplayed();
  }

  public void enterNewsletterEmail(String myEmail) {
    newsletter_Email.sendKeys(myEmail);
  }

  public void enterNewsletterPassword(String myPassword) {
    newsletter_Password.sendKeys(myPassword);
  }

  public void submitNewsletterRequest() {
    newsletter_Submit.click();
  }

  public String getNewsletterResponse() {
    browserActions.waitlogic();
    return newsletter_response.getText();
  }
}
