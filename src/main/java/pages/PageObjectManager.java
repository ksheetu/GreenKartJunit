package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public LandPage landpage;
	public OffersPage offerspage;
	public CheckoutPage checkoutpage;
	public PageObjectManager(WebDriver driver){
		this.driver=driver;
	}
	public LandPage getLandPage(){
		return landpage= new LandPage(driver);
	}
	
	public OffersPage getOffersPage(){
		return offerspage= new OffersPage(driver);
	}
	
	public CheckoutPage getCheckoutPage(){
		return checkoutpage= new CheckoutPage(driver);
	}
	
	
}
