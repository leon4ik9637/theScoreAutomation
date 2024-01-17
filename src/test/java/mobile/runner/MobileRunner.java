package mobile.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/mobile", // path of feature files
        glue = "mobile/stepDefs", // path of steps package
        tags = "@Test", //Tags of scenarios to run them (Some are Smoke, some are Regression, so I just put @Test)
        plugin = {"pretty", "html:target/cucumber-reports/mobile/Cucumber.html"}
        // ,dryRun = true
        // ,monochrome = true // printing the result to console log in more readable way
)

public class MobileRunner {
}
