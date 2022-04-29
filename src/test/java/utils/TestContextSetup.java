package utils;

import java.util.List;

import org.openqa.selenium.WebElement;

import pages.PageObjectManager;

public class TestContextSetup {
	public TestContextSetup testContextSetup;
	public BaseTest baseTest;
	public GenericUtil genericUtil; 
	public PageObjectManager pageObjectManager;
	public String landPageItemName;
	public List<WebElement>ItemList;
	
	public TestContextSetup(){
		baseTest= new BaseTest();
		pageObjectManager=new PageObjectManager(baseTest.WebdriverManager());
				
		genericUtil=new GenericUtil(baseTest.WebdriverManager());
	}
}
