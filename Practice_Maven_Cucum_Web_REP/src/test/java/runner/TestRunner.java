package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features/login.feature",
glue= {"steps"},

// Simple HTML Report.
//plugin = { "pretty", "html:target/htmlreports" }

// Extended HTML Report.33
plugin = {"json:target/cucumber.json"}

)

public class TestRunner {

}
