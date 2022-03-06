package com.getYourLawyer.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class is runner class and ve uses this class to set tags and run tests
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/getYourLawyer/stepDefinitions",
        dryRun=false,
        tags=""
)
public class CucumberTestRunner {
}
