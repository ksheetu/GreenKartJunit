package stepdefinitions;






import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandPage;
import pages.PageObjectManager;
import utils.GenericUtil;
import utils.TestContextSetup;

public class LandPageStepDefinition {
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public LandPage landpage;
	public String landPageExpextedTitle="GreenKart - veg and fruits kart";
	public String LandPageItemName;
	public GenericUtil genericutils;
	
	public LandPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
		landpage=testContextSetup.pageObjectManager.getLandPage();
	}
	@Given("User is on LandPage")
	public void user_is_on_land_page() {
		Assert.assertEquals(landpage.getLandPageTitle(),landPageExpextedTitle);
		
	}

	@When("^User enters short name (.+) in search$")
	public void sendItemName(String itemName) {
		
		testContextSetup.landPageItemName=landpage.getItemName(itemName).split("-")[0].trim();
		
		System.out.println(testContextSetup.landPageItemName);
	}


	
	
	
	@When("^adds (.+) for (.+)  on land page$")
	public void adds_qty_for_item_on_land_page(Integer quantity,String ItemName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		landpage.incItemQty(ItemName, quantity);
	}
	
	@When("Proceed to Checkout")
	public void navigatesToCheckoutPage() {
		landpage.click_Cart();
	}
	
	@When("Clicks on Add to cart")
	public void addtocart_Click() {
		landpage.click_AddToCart();
		
		
	}
	
	
	@Then("Print total number of Items and  Item Names on Land Page")
	public void Print_all_Item_Names_on_LandPage() {
		testContextSetup.ItemList=landpage.getAllItemnames();
		System.out.println(testContextSetup.ItemList.size());
		testContextSetup.genericUtil.printAllListElements(testContextSetup.ItemList);;
		System.out.println(testContextSetup.baseTest.countWeb);
	}
	
	@Then("Print total number of Items and  Item Names on Land Page in a File")
	public void PrinttotalItemsAndItemNameToFile() {
		testContextSetup.ItemList=landpage.getAllItemnames();
		testContextSetup.genericUtil.printAllListElementsToFile(testContextSetup.ItemList);
		System.out.println(testContextSetup.baseTest.countWeb);
	}
	@Then("Print total number of Items and  Item short Names on Land Page in a File")
	public void PrinttotalItemsAndItemShortNameToFile() {
		testContextSetup.ItemList=landpage.getAllItemnames();
		testContextSetup.genericUtil.createAndWriteNewFileUsingFOS(testContextSetup.ItemList);
		System.out.println(testContextSetup.baseTest.countWeb);
	}
	
	
	
}
