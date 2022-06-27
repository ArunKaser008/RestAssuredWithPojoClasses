package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/steps"},
//        plugin = {"pretty", "html:test-output", "json:target/cucumber.json", "html:target/cucumber.html",
//              },
        tags = "@Abc",
        monochrome = true,
        publish = true
)

public class TestRunner {


}
