package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import objectrepository.GmailLoginPage;
import objectrepository.RediffHomePage;

public class LoginPage {
	
	@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		GmailLoginPage lPage=new GmailLoginPage(driver);
		lPage.getUsername().sendKeys("aroram2@rediffmail.com");
		lPage.getPassword().sendKeys("Schw@b3112");
		lPage.getRememberBtn().click();
		lPage.getsignInBtn().click();	
		lPage.getRediffHomePageLink().click();

		RediffHomePage homePage=new RediffHomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(homePage.getLatestTab()));
		homePage.getLatestTab().click();
	}
}
