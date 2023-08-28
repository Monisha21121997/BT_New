package pageObjects;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;
import utils.BrowserActions;

public class SitemapPageObjects extends BaseUtils {
  WebDriver driver;
  BrowserActions browserActions;
  static Logger log = LogManager.getLogger(SitemapPageObjects.class);

  public SitemapPageObjects(WebDriver driver){
    this.driver = driver;
    browserActions = new BrowserActions(driver);
    PageFactory.initElements(driver,this);
  }

  //Finding the Page WebElements
  @FindBy(xpath = "//div[contains(@class,'sitemap')]//a")
  private List<WebElement> page_links;

  //Public Getter Methods
  public void openSitemapPage(String pageURL){
    log.info("-------------------------------------------------------------------");
    log.info("----------------- Navigating to "+pageURL+ " ------------------------");
          browserActions.navigateToPage(pageURL);
    log.info("----------------- Navigated to "+pageURL+ " ------------------------\n\n");
  }
  public void validateLinks(){
    log.info("-------------------------------------------------------------------");
    log.info("----- Validating the URL links -----");
      findBrokenElements(page_links,"href");
    log.info("-----------------------------------------------------------------\n\n");
  }
}
