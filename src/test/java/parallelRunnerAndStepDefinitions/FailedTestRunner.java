package parallelRunnerAndStepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Runner File to retry failed test cases Configuration is same as main runner file
 */

@CucumberOptions(
    features = {"@target/failedTestCases.txt"},
    glue = {"parallelRunnerAndStepDefinitions"},
    plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output/", "rerun:target/failedTestCases.txt"},
    monochrome = true
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
