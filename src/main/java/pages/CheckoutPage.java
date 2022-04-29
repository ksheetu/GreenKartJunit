package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	
	By productName=By.cssSelector("p.product-name");
	By quantity=By.cssSelector("p.quantity");
	By amount=By.cssSelector("p.amount");
	By promoButton=By.cssSelector(".promoBtn");
	By placeOrderButton=By.xpath("//button[text()='Place Order']");
	
	public CheckoutPage(WebDriver driver){
		this.driver= driver;
	}
	
	public String getItemname() {
		return driver.findElement(productName).getText();
	}
	
	public String getAmount() {
		return driver.findElement(amount).getText();
	}
	
	
	
	
	public String  getQuantity() {
		return driver.findElement(quantity).getText().split(" ")[0];
	}
	
	public boolean promoButton_isDisplayed() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean placeOrderButton_isDisplayed() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
}
