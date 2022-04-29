package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public FileInputStream fis;
	public String ConfigFilePath="\\src\\test\\resources\\Config.properties";
	public String userdir;
	public Properties prop;
	public String browserName;
	public int countWeb =0;
	
	public WebDriver WebdriverManager(){
		userdir=System.getProperty("user.dir");
		try {
			fis=new FileInputStream(userdir+ConfigFilePath);
			 prop= new Properties();
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Invalid File Specified");
		}
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		browserName=browser_maven!=null?browser_maven:browser_properties;
		
		if (driver==null) {
			
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", userdir+"\\src\\test\\resources\\drivers\\chromedriver.exe");
				this.driver= new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				this.driver= new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(prop.getProperty("AppUrl"));
		} 
		this.countWeb++;
		return driver;
		
	}
}
