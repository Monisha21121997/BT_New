package parallelRunnerAndStepDefinitions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/testCases",
        glue = {"parallelRunnerAndStepDefinitions"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output/"},
        monochrome = true
)

public class ParallelTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}