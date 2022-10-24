package academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import resources.Base;

public class PageLogo extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validatePageLogo() throws IOException
	{
		Boolean flag1=driver.findElement(By.xpath("//button[text()='NO THANKS']")).isDisplayed();
		if(flag1)
		{
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		}
		HomePageObjects hp=new HomePageObjects(driver);
		Boolean flag=hp.getLogoIcon().isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
