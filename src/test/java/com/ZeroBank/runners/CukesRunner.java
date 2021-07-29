package com.ZeroBank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/zeroBank-report.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/ZeroBank/step_definitions",
        dryRun = false,
        tags = "@smoke"
)


public class CukesRunner {
}
