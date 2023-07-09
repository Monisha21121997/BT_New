package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class performs the generic actions needed from webdriver driver object should be passed by
 * the calling class
 */
public class BrowserActions {

  private WebDriver driver;
  private WebDriverWait webDriverWait;
  private JavascriptExecutor jse;

  static Logger log = LogManager.getLogger(BrowserActions.class);

  public BrowserActions(WebDriver driver) {
    this.driver = driver;
    jse = (JavascriptExecutor) driver;
  }

  public Boolean waitlogic() {
    webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    ExpectedCondition<Boolean> jqueryResponse = driver -> {
      try {
        return ((Long) jse.executeScript("return jQuery.active") == 0);
      } catch (Exception e) {
        return true;
      }
    };

    return webDriverWait.until(jqueryResponse);
  }

}
