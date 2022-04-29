package stepdefinitions;





import org.junit.Assert;


import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinition {

	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutpage;
	
	public CheckOutPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^User verifies (.+) and (.+) on Checkout Page$")
	public void verifyItemnameandQtyOncheckout_page(String itemName,String quantity) {
		System.out.println(testContextSetup.baseTest.countWeb);
		this.checkoutpage=testContextSetup.pageObjectManager.getCheckoutPage();
		//testContextSetup.genericUtil.WaitTillElmDisplayed(itemName, 10);
		
		
		Assert.assertEquals(checkoutpage.getItemname().substring(0, 3).toLowerCase(), itemName);
		Assert.assertEquals(checkoutpage.getQuantity(), quantity);
		
		
	}
	
	@Then("User verifies Apply button and Place Order button present on Checkout Page")
	public void verifies_apply_button_and_place_order_button_on_checkout_page() {
		System.out.println(testContextSetup.baseTest.countWeb);
		this.checkoutpage=testContextSetup.pageObjectManager.getCheckoutPage();
		Assert.assertTrue(checkoutpage.promoButton_isDisplayed());
		Assert.assertTrue(checkoutpage.placeOrderButton_isDisplayed());
		
	}
}