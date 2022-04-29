package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue="stepdefinitions",
		monochrome=true,
		tags="@CheckoutPage or @LandPage",
		dryRun=false,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"
				
		})
public class JunitTestRunnerTest  {
	
	  

}