package com.example.demo.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/example/demo/cucumber/resources",
        glue = "/stepDefinitions",
        plugin = { "json:target/cucumber.json", "pretty",
                "html:target/cucumber-reports" }
)
public class CucumberTest {
}
