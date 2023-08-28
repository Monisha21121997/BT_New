package RunnerAndStepDefinitions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

/**
 * Test Runner File to start the test execution This file is called from maven to start the tests It
 * uses Cucumber TestNG Annotations It manages the binding between Feature file and StepDefinitions
 * file Parallel Testing is toggled from this file Reporting is toggled from this file
 */

@CucumberOptions(
    features = "src/test/resources/testCases",
    glue = {"RunnerAndStepDefinitions"},
    plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output/", "rerun:target/failedTestCases.txt"},
    monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}