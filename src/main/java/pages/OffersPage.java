package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage  {
	public WebDriver driver;
	
	By search = By.cssSelector("input[type='search']");
	By itemName = By.cssSelector("td:nth-of-type(1)");
	
	public OffersPage(WebDriver driver){
		this.driver=driver;
	}

	public void sendTextToSearch(String data){
		driver.findElement(search).sendKeys(data.trim());
	}
	public String getItemName() {
		return driver.findElement(itemName).getText();
	}
}
