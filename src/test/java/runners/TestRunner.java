package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = {"stepDefinitions"},
        features = {"src/test/java/features"},
        tags = "@api",
        monochrome = true
)
public class TestRunner{
}