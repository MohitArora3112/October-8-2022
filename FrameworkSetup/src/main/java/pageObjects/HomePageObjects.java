package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;
	
	By loginLink=By.cssSelector(".pull-right li:nth-child(4) a");
	By logoIcon=By.cssSelector(".navbar-header");
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getLoginLink()
	{
		return driver.findElement(loginLink);
	}
	public WebElement getLogoIcon()
	{
		return driver.findElement(logoIcon);
	}
}
