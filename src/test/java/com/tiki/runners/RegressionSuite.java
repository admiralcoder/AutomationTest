package com.tiki.runners;
import cucumber.api.CucumberOptions;
	import cucumber.api.testng.AbstractTestNGCucumberTests;


	@CucumberOptions(
		plugin= {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags="@Regression",
		features = "src\\test\\resources\\com\\tiki\\features", 
		glue="com\\tiki\\step_definitions",
		dryRun = false
		)

	public class RegressionSuite extends AbstractTestNGCucumberTests{

	
}
