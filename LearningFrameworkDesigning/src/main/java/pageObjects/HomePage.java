package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	By textLabel=By.xpath("//button[text()='NO THANKS']");
	By mailLink=By.cssSelector(".pull-left li:nth-child(2) a");
	By loginLink=By.cssSelector(".pull-right li:nth-child(4) a");
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getTextLabel()
	{
		return driver.findElement(textLabel);
	}
	
	public WebElement getMaillink()
	{
		return driver.findElement(mailLink);
	}
	
	public WebElement getloginlink()
	{
		return driver.findElement(loginLink);
	}
}
