package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	public WebDriver driver;

	@FindBy(css="#user_email")
	WebElement username;
	
	@FindBy(css="#user_password")
	WebElement password;
	
	@FindBy(name="commit")
	WebElement signInBtn;
	
	public WebElement getUsername()
	{
		return username;
	}
	public WebElement getPassword()
	{
		return password;
	}
	public WebElement getSignInBtn()
	{
		return signInBtn;
	}
	
	
}
