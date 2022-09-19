package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\java\\feature\\CreateIncident.feature",
                 glue="stepdefinition",
                 monochrome=true)

public class RunCucumberTest extends AbstractTestNGCucumberTests{

}
