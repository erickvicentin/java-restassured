package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "Steps",
    plugin = {
      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
      "json:target/cucumber-reports.json"
    },
    tags = "@API")
public class Runner {}
