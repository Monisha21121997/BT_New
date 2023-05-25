package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    WebDriver driver;

    //Intializing PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static Logger log = LogManager.getLogger(HomePage.class);

    //WebElements

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
            Assert.fail("<----- Navbar is not displayed ----->");
        }
    }

    public void isLogoVisible() {
        log.info("----------- Checking if the BT Logo is visible or not -----------");
        if (bt_logo.isDisplayed()) {
            log.info("----------- BT Logo is visible -----------");
        } else {
            log.error("<----------- BT Logo is not displayed --------->");
            Assert.fail("<----- BT Logo is not displayed ----->");
        }
    }

    public void isHeaderLinksDisplayed() {
        if (nav_items.size() >= 5) {
            log.info("----------- Total " + nav_items.size() + " links are available in logo -----------");
            for (WebElement e : nav_items) {
                log.info(e.getText());
            }
        } else Assert.fail("<----- All Nav Links are not authored ----->");
    }
}
