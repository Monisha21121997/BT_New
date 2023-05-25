package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverManager {

  private WebDriver driver;
  private static DriverType driverType;
  private static EnvironmentType environmentType;

  public WebDriverManager() {
    driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
  }

  public WebDriver getDriver() {
    if (driver == null) {
      driver = createDriver();
    }
    return driver;
  }

  public WebDriver createDriver() {
    switch (environmentType) {
      case LOCAL:
        driver = createLocalDriver();
        break;
      case REMOTE:
        driver = createRemoteDriver();
        break;
    }
    return driver;
  }

  public WebDriver createRemoteDriver() {
    throw new RuntimeException(
        "RemoteWebDriver is not implemented. Please implement it in WebDriverManager class");
  }

  public WebDriver createLocalDriver() {
    switch (driverType) {
      case EDGE:
        driver = new EdgeDriver();
        break;
      case FIREFOX:
        driver = new FirefoxDriver();
        break;
      case SAFARI:
        driver = new SafariDriver();
        break;
      case CHROME:
        driver = new ChromeDriver();
        break;
    }

    if (FileReaderManager.getInstance().getConfigFileReader().getWindowSize()) {
      driver.manage().window().maximize();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
        FileReaderManager.getInstance().getConfigFileReader().getImplicitWait()));
    return driver;
  }

  public void closeDriver() {
    driver.close();
    driver.quit();
  }
}
