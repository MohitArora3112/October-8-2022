package section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Handling Checkboxes
		Boolean Result=driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected();
		Assert.assertFalse(Result);
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();
		
		Boolean Result1=driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).isSelected();
		Assert.assertTrue(Result1);
		
		int checkboxCount=driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("Count of the Checkboxes are: "+checkboxCount);	
		Assert.assertEquals(6, checkboxCount);
	}
}
