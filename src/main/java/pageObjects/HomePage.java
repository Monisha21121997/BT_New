package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

/**
 * This is a Page Repository class using the Selenium Page Factory concept.
 * Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver, and it is very optimized.
 * PageFactory is used to Initialize Elements of a Page class without having to use 'FindElement‘ or ‘FindElements‘.
 * Annotations can be used to supply descriptive names of target objects to improve code readability.
 */
public class HomePage {

    WebDriver driver;

    //Initializing PageFactory using class Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static Logger log = LogManager.getLogger(HomePage.class);

    /**
     * @FindBy Annotation
     * As the name suggest, it helps to find the elements in the page using By strategy.
     * It can accept TagName, PartialLinkText, Name, LinkText, Id, Css, ClassName, XPath as attributes.
     */

    //Finding the Page WebElements
    @FindBy(xpath = "//nav[contains(@class,'navbar')]")
    private WebElement nav_container;
    @FindBy(xpath = "//a[@class='logo__href white__logo']")
    private WebElement bt_logo;

    @FindBy(xpath = "//ul[contains(@class,'navbar-nav')]//li[contains(@class,'mx-2 nav-item')]")
    private List<WebElement> nav_items;

    //Public getter methods

    public void isNavContainerVisible() {
        log.info("----------- Checking if the Navbar is visible or not -----------");
        if (nav_container.isDisplayed()) {
            log.info("<----- Navbar is visible ----->");
        } else {
            log.error("<----- Navbar is not displayed ----->");
            assertThat(nav_container.isDisplayed()).isTrue();
        }
    }

    public void isLogoVisible() {
        log.info("----------- Checking if the BT Logo is visible or not -----------");
        if (bt_logo.isDisplayed()) {
            log.info("----------- BT Logo is visible -----------");
        } else {
            log.error("<----------- BT Logo is not displayed --------->");
            assertThat(bt_logo.isDisplayed()).isTrue();
        }
    }

    public void isHeaderLinksDisplayed() {
        if (nav_items.size() >= 5) {
            log.info("----------- Total " + nav_items.size() + " links are available in logo -----------");
            for (WebElement e : nav_items) {
                log.info(e.getText());
            }
        } else{
            log.error("<----------- Nav links are not authored --------->");
            assertThat(nav_items.size()).isGreaterThanOrEqualTo(5);
        }
    }
}
