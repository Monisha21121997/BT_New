package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    //Initializing PageFactory
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@class='nav-item nav__menu__option__icon anonymous__user position-relative mb-1']//span")
    private WebElement userIcon;

    @FindBy(id = "login-submit")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(xpath = "//form[@id='login-form']//input[@placeholder='Email']")
    private WebElement userName;

    @FindBy(xpath = "//form[@id='login-form']//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//li[@class='nav-item nav__menu__option__icon user position-relative mb-1']")
    private WebElement loggedInUserIcon;

    //Public getter Methods

        public void openHomepageURL(){
            driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
        }

        public void clickUserIcon(){
            userIcon.click();
        }

        public void isLoginPopupVisible(){
            submitButton.isDisplayed();
            Assert.assertTrue(submitButton.isDisplayed(),"Login button is Not Visible");
        }

        public void enterUsername(String my_username){
            userName.sendKeys(my_username);
        }

        public void enterPassword(String my_password){
            password.sendKeys(my_password);
        }

        public void clickSigninButton(){
            submitButton.click();
        }

        public void isProfileDisplayed(){
            try{
                if (loggedInUserIcon.isDisplayed()) loggedInUserIcon.click();
            }catch (NoSuchElementException e){
                Assert.assertTrue(Boolean.FALSE,"User is successfully logged in");
            }
        }
}
