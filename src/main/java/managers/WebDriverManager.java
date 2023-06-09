package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * This class is responsible to get us the WebDriver, when we ask for it.
 * Only exposes two methods getDriver() and closeDriver().
 * GetDriver method will decide if the driver is already created or needs to be created.
 * closeDriver method will terminate the created driver.
 * Selenium WebDriver is not thread-safe by default.
 * A variable should be accessed by same thread by which it is created, we can use ThreadLocal variables.
 * This class makes variables thread safe & parallel execution can happen without any issues.
 */
public class WebDriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    WebDriver driverLocal = driver.get();
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driverLocal == null) {
            driverLocal = createDriver();
            driver.set(driverLocal);
        }
        return driverLocal;
    }

    public WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driverLocal = createLocalDriver();
                break;
            case REMOTE:
                driverLocal = createRemoteDriver();
                break;
        }
        return driverLocal;
    }

    public WebDriver createRemoteDriver() {
        throw new RuntimeException(
                "RemoteWebDriver is not implemented. Please implement it in WebDriverManager class");
    }

    public WebDriver createLocalDriver() {
        switch (driverType) {
            case EDGE:
                driverLocal = new EdgeDriver();
                break;
            case FIREFOX:
                driverLocal = new FirefoxDriver();
                break;
            case SAFARI:
                driverLocal = new SafariDriver();
                break;
            case CHROME:
                driverLocal = new ChromeDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigFileReader().getWindowSize()) {
            driverLocal.manage().window().maximize();
        }
        driverLocal.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                FileReaderManager.getInstance().getConfigFileReader().getImplicitWait()));
        return driverLocal;
    }

    public void closeDriver() {
        driverLocal.close();
        driverLocal.quit();
    }
}