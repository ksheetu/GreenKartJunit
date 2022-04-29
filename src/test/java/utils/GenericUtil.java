package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericUtil {
	public WebDriver driver;

	public String Parentwindowhandle;
	public String Childwindowhandle;

	public String fileName;
	public Date date;
	public File file;
	public FileWriter fileWriter;
	public FileInputStream fis;
	public FileOutputStream fos;
	public WebDriverWait wait;
	
	public GenericUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void switchWindowToChild() {
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> itr = windowhandles.iterator();
		String Parentwindowhandle = itr.next();
		String Childwindowhandle = itr.next();
		driver.switchTo().window(Childwindowhandle);
	}

	public void printAllListElements(List<WebElement> list) {
		System.out.println(list.size());
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());

		}
	}

	// Writing to File using FileWriter
	public void printAllListElementsToFile(List<WebElement> list) {
		System.out.println("printAllListElementsToFile");
		file = createNewFile();
		System.out.println(file.getName());
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("File Writer Creation Error!!");
		}
		System.out.println(list.size());
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			String dataToFile = itr.next().getText();
			if (file.canWrite()) {
				try {
					System.out.println(dataToFile);
					fileWriter.write(dataToFile + "\n");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Assert.fail("Error While Writing to File");
				}
			} else {
				Assert.fail("Cant Write To File..Check File Write Rights!!");
			}
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("FileWriter Close Error!!");
		}
	}

	// Creation of File using File
	public File createNewFile() {
		System.out.println("createNewFile");

		date = new Date();
		String timeStamp = date.toString().replace(":", "_").replace(",", "_").replace(" ", "_");
		fileName = "FileItemList" + timeStamp + ".txt";

		file = new File("F:\\Radical\\Ecommerce\\src\\test\\java\\FileOutput\\" + fileName);
		try {
			if (file.createNewFile()) {
				System.out.println("File Created " + file.getName());
			} else {
				System.out.println("File not Created");
				Assert.fail("File Creation Error!!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("File Creation Error!!");
		}

		return file;

	}

	// Creation of File using FileInputStream
	public FileOutputStream createNewFileUsingFOS(){
		date = new Date();
		String timeStamp = date.toString().replace(":", "_").replace(",", "_").replace(" ", "_");
		fileName = "FosItemList" + timeStamp + ".txt";
		String fosPath="F:\\Radical\\Ecommerce\\src\\test\\java\\FileOutput\\";
		try {
			fos = new FileOutputStream(fosPath+fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fos;
	}
	
	//Writing to file using fos
	public void createAndWriteNewFileUsingFOS(List<WebElement> list) {
		 this.fos=createNewFileUsingFOS();
		Iterator<WebElement>itr=list.iterator();
		while (itr.hasNext()) {
			 String itemname=itr.next().getText().substring(0,3);
			 System.out.println(itemname);
			 byte[] data=itemname.getBytes();
			 byte[] startAndEnd="|".getBytes();		
			 
			 try {
				fos.write(startAndEnd);
				fos.write(data);
				fos.write(startAndEnd);
				fos.write(10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WaitTillElmDisplayed(By elm,long waitTime){
		 WebElement elem=driver.findElement(elm);
		wait= new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOf(elem));
		
	}
	
	public void WaitTillElmDisplayed(String ItemName,long waitTime){
		 WebElement elem=driver.findElement(By.xpath("//[text()='ItemName']"));
		wait= new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOf(elem));
		
	}
}
