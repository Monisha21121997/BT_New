package RunnerAndStepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Runner File to retry failed test cases Configuration is same as main runner file
 */

@CucumberOptions(
    features = {"@target/failedTestCases.txt"},
    glue = {"RunnerAndStepDefinitions"},
    plugin = {"pretty", "timeline:test-output/", "rerun:target/failedTestCases.txt"},
    monochrome = true
)

public class FailedCaseRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
