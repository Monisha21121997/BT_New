package pageObjects;

import managers.FileReaderManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.*;

/**
 * This is a Page Repository class using the Selenium Page Factory concept.
 * Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver, and it is very optimized.
 * PageFactory is used to Initialize Elements of a Page class without having to use 'FindElement‘ or ‘FindElements‘.
 * Annotations can be used to supply descriptive names of target objects to improve code readability.
 */
public class LoginPage {

    WebDriver driver;

    //Initializing PageFactory using class Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static Logger log = LogManager.getLogger(LoginPage.class);

    /**
     * @FindBy Annotation
     * As the name suggest, it helps to find the elements in the page using By strategy.
     * It can accept TagName, PartialLinkText, Name, LinkText, Id, Css, ClassName, XPath as attributes.
     */
    //Finding the Page WebElements
    @FindBy(xpath = "//li[contains(@class,'anonymous__user')]")
    private WebElement userIcon;

    @FindBy(id = "login-submit")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(xpath = "//form[@id='login-form']//input[@name='email']")
    private WebElement userName;

    @FindBy(xpath = "//form[@id='login-form']//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//li[@class='nav-item nav__menu__option__icon user position-relative mb-1']")
    private WebElement loggedInUserIcon;

    //Public getter Methods

    public void openHomepageURL() {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void isLoginPopupVisible() {
        assertThat(submitButton.isDisplayed()).isTrue();
    }

    public void enterUsername(String my_username) {
        userName.sendKeys(my_username);
    }

    public void enterPassword(String my_password) {
        password.sendKeys(my_password);
    }

    public void clickSigninButton() {
        submitButton.click();
    }

    public void isProfileDisplayed() {
        log.info("<---------------- Checking if the user is logged in or not -------------->");
        if (loggedInUserIcon.isDisplayed()) {
            log.info("<-------------- User is logged -------------->");
            loggedInUserIcon.click();
        } else {
            log.info("<-------------- User is unable to login -------------->");
            assertThat(loggedInUserIcon.isDisplayed()).isTrue();
        }
    }
}
