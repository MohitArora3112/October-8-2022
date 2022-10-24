package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {
	
	WebDriver driver;
	
	public RediffHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By latestTab=By.cssSelector("#tabtable div:nth-child(2)");
	
	public WebElement getLatestTab()
	{
		return driver.findElement(latestTab);
	}

}
