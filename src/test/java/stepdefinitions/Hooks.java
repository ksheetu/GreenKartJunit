package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void afterScenario() {
		testContextSetup.baseTest.WebdriverManager().quit();
	}

	@io.cucumber.java.AfterStep
	public void AfterStep(Scenario Scenario)
	{
		if (Scenario.isFailed()) {
			
		
		WebDriver driver=testContextSetup.baseTest.WebdriverManager();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			byte[]data=FileUtils.readFileToByteArray(src);
			String scenarioName=Scenario.getName();
			System.out.println(scenarioName);
			Scenario.attach(data, "image/png", "image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
