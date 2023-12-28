package Runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefile/enrolment_stats.feature" , glue = {"Stepdefinition"},
dryRun=false,
monochrome=true,
plugin= {"html:report/WebReport","json:report/jsonreport.json" }
)

public class runnerclass {
	
	
}
