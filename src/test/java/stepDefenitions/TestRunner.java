package stepDefenitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/cucumberBDD",glue={"stepDefenitions"},
monochrome = true,
plugin = {"pretty","html:target/HtmlReports"},
tags = "@TC_011")
public class TestRunner {
}
