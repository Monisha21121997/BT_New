package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context){
        testContext = context;
    }

    //Order 1 will run before Order 0
    @After(order = 1)
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ","_");
                //Take Screenshot
                byte[] sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcePath,"image/png", screenshotName);
        }
    }

    @After(order = 0)
    public void TearDown() {
        testContext.getWebDriverManager().closeDriver();
    }

}
