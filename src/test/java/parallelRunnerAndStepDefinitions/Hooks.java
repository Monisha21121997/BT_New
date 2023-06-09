package parallelRunnerAndStepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Unlike TestNG Annotations, cucumber supports only two hooks (Before & After).
 *
 * @before hook gets executed well before any other test scenario
 * @after hook gets executed after executing the scenario.
 */
public class Hooks {

    TestContext testContext;
    static Logger log = LogManager.getLogger(Hooks.class);

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public static void BeforeScenario(Scenario scenario) {
        log.info("-----------------------------------------------------------------------------");
        log.info("Feature ID- " + scenario.getId());
        log.info(" Executing Scenario ---> " + scenario.getName());
        log.info("-----------------------------------------------------------------------------");
    }

    //Order 1 will run before Order 0
    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        log.info("-----------------------------------------------------------------------------");
        log.info("======= Scenario execution is finished: " + scenario.getName());
        log.info("-----------------------------------------------------------------------------\n\n");

        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            //Take Screenshot
            byte[] sourcePath = ((TakesScreenshot) testContext.getWebDriverManager()
                    .getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    @After(order = 0)
    public void TearDown() {
        log.info("-----------------------------------------------------------------------------");
        log.info("::::::::::::: Terminating browser session :::::::::::::");
        log.info("-----------------------------------------------------------------------------\n\n");
        testContext.getWebDriverManager().closeDriver();
    }

}
