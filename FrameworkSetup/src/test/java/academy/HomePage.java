package academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized.");
		driver.get(prop.getProperty("url"));
	}
	
	@Test (dataProvider="getData")
	public void openHomePage(String username, String password) throws IOException
	{

		HomePageObjects hp=new HomePageObjects(driver);
		Boolean flag=driver.findElement(By.xpath("//button[text()='NO THANKS']")).isDisplayed();
		if(flag)
		{
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		}
		hp.getLoginLink().click();
		LoginPageObjects lp=new LoginPageObjects(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginBtn().click();
		Assert.assertEquals(lp.getPageHeaderLabel().getText(),"WebServices Testing using SoapUI");
		log.info("Message validated successfully.");
		}
	
	@Test
	public void validatePageLogo() throws IOException
	{
		Boolean flag=driver.findElement(By.xpath("//button[text()='NO THANKS']")).isDisplayed();
		if(flag)
		{
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		}
		HomePageObjects hp=new HomePageObjects(driver);
		Boolean flag1=hp.getLogoIcon().isDisplayed();
		Assert.assertTrue(flag1);
	}
	
	@Test
	public void validatePageLogoFailed() throws IOException
	{
		Boolean flag=driver.findElement(By.xpath("//button[text()='NO THANKS']")).isDisplayed();
		if(flag)
		{
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		}
		HomePageObjects hp=new HomePageObjects(driver);
		Boolean flag1=hp.getLogoIcon().isDisplayed();
		Assert.assertFalse(flag1);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="Mohit";
		obj[0][1]="Schw@b3112";
		obj[1][0]="Vinay";
		obj[1][1]="Schw@b3112";
		obj[2][0]="Jatin";
		obj[2][1]="Schw@b3112";
		
		return obj;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser is closed.");
	}
	

}
