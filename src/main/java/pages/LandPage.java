package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandPage {
	public LandPage landpage;
	public WebDriver driver;
	public OffersPage offerspage;
	
	public By search = By.cssSelector("input[type='search']");
	public By TopDealsLink = By.cssSelector("a[href='#/offers']");
	public By productName = By.cssSelector("h4.product-name");
	public By AddToCart =By.xpath("//button[text()='ADD TO CART']");
	public By PROCEEDTOCHECKOUT=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	
	public By incqty = By.cssSelector("a.increment");
	public By cart	= By.cssSelector("a.cart-icon");
	
	public LandPage(WebDriver driver){
		this.driver=driver;
	}
	

	
	public String getItemName(String data){
		driver.findElement(search).sendKeys(data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(productName).getText();
	}
	public String getLandPageTitle(){
		return driver.getTitle();
	}
	
	public void topDealsClick(){
		driver.findElement(TopDealsLink).click();
		
	}
	
	public List<WebElement> getAllItemnames(){
		List<WebElement>itemNames=driver.findElements(productName);
		System.out.println(itemNames.size());
		return itemNames;
		
	}
	
	public void incItemQty(String itemName,int quantity) {
		List<WebElement>itemNames=driver.findElements(productName);
		
		Iterator<WebElement>itr=itemNames.iterator();
		
		while (itr.hasNext()) {
			String productName=itr.next().getText().substring(0, 3);
			System.out.println(productName);
			System.out.println(itemName);
			System.out.println(quantity);
			if (productName.equalsIgnoreCase(itemName)) {
				int i=1;
				
				while (i<quantity) {
					System.out.println(i);
					driver.findElement(incqty).click();
					i++;
					
				}
				
			} else {
				itr.next();
				
			}
		}
		
	}
	
	public void click_Cart() {
		driver.findElement(cart).click();
	}
	
	public void click_AddToCart(){
		
		driver.findElement(AddToCart).click();
	}
	
	public void click_PROCEEDTOCHECKOUT(){
		click_Cart();
		driver.findElement(PROCEEDTOCHECKOUT).click();
		
	}
}
