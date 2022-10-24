package objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPageFactory {

	WebDriver driver;
	
	@FindBy(css="#login1")
	WebElement username;
	
	@FindBy(name="proceed")
	WebElement signInBtn;
	
	@FindBy(css="#password")
	WebElement password;
	
	
	public GmailLoginPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsername()
	{
		return username;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getsignInBtn()
	{
		return signInBtn;
	}
	
	
	
}
