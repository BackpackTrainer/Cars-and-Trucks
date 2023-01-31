package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberOptions(
        features = "src/test/java/com/example/demo/cucumber/resources",
        glue = "com.example.demo.cucumber.stepDefinitions")
@RunWith(Cucumber.class)
public class RunIt {
}

