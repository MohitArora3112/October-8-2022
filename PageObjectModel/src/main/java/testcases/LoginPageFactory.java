package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectrepository.GmailLoginPageFactory;

public class LoginPageFactory {
	@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		GmailLoginPageFactory lPage=new GmailLoginPageFactory(driver);
		lPage.getUsername().sendKeys("aroram2@rediffmail.com");
		lPage.getPassword().sendKeys("Schw@b3112");
		lPage.getsignInBtn().click();	

	}
}
