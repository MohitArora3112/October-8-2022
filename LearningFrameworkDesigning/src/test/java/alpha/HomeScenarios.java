package alpha;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;

public class HomeScenarios extends Base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initializeMainDriver() throws IOException
	{
		HomeScenarios hs=new HomeScenarios();
		driver=hs.initializeDriver();
	}
	
	@Test
	public void uiValidation()
	{
		driver.get("http://www.qaclickacademy.com/");
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.getloginlink().isDisplayed());
		Assert.assertTrue(hp.getMaillink().isDisplayed());
		Assert.assertTrue(hp.getTextLabel().isDisplayed());		
	}
	
	@Test
	public void loginClick()
	{
		driver.get("http://www.qaclickacademy.com/");
		HomePage hp=new HomePage(driver);
		hp.getloginlink().click();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
