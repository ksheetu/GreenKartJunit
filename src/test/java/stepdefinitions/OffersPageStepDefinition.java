package stepdefinitions;

import org.openqa.selenium.WebDriver;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.LandPage;
import pages.OffersPage;

import utils.TestContextSetup;

public class OffersPageStepDefinition {
	public TestContextSetup testContextSetup;
	public LandPage landpage;
	public OffersPage offerspage;

	public String offerspageItemName;
	
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		
		
	}
	@Then("^validate the (.+)in offers Page is same as itemName from landpage$")
	public void validate_the_sameitem__in_offers_page(String itemName) {
		SwitchtoOffersPage();
		offerspage=testContextSetup.pageObjectManager.getOffersPage();
		offerspage.sendTextToSearch(itemName);
		offerspageItemName=offerspage.getItemName();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(testContextSetup.baseTest.countWeb);
		Assert.assertEquals(offerspageItemName, testContextSetup.landPageItemName);
	}
	
	public void SwitchtoOffersPage() {
		landpage=testContextSetup.pageObjectManager.getLandPage();
		landpage.topDealsClick();
		testContextSetup.genericUtil.switchWindowToChild();
		
	}
}
