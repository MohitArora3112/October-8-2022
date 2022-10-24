package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLoginPage {

	
	WebDriver driver;
	By username=By.cssSelector("#login1");
	By password=By.cssSelector("#password");
	By signInBtn=By.name("proceed");
	By rememberBtn=By.id("remember");
	By rediffHomePageLink=By.linkText("rediff.com");
	
	public GmailLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getRememberBtn()
	{
		return driver.findElement(rememberBtn);
	}
	
	public WebElement getsignInBtn()
	{
		return driver.findElement(signInBtn);
	}
	
	public WebElement getRediffHomePageLink()
	{
		return driver.findElement(rediffHomePageLink);
	}
	
	public void getDynamicWait()
	{
		
	}
	
	
}
