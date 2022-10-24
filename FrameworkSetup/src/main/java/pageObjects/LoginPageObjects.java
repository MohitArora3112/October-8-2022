package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	By username=By.cssSelector("#user_email");
	By password=By.cssSelector("#user_password");
	By loginBtn=By.name("commit");
	By labelHeader=By.className("navbar-brand");
	
	public LoginPageObjects(WebDriver driver)
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
	
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginBtn);
	}
	
	public WebElement getPageHeaderLabel()
	{
		return driver.findElement(labelHeader);
	}
}
