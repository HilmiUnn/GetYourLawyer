package com.getYourLawyer.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *This class's main responsibility is running failed test cases one more time.
 * it gets failed test numbers from a txt file which is located in the target folder.
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/getYourLawyer/stepDefinitions"
)
public class FailedTestsRunner {

}
