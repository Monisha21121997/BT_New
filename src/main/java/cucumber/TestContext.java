package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

/**
 * To share the Test Context / Scenario Context / Test State with all the Step Definitions file.
 * TestContext is the parent class and the medium to share the information between the different steps in a test.
 * Scenario Context is a class that holds the test data information specifically.
 * Cucumber supports PicoContainer (Dependency Injection Containers).
 */
public class TestContext {

    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
