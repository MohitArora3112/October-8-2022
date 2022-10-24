package section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//Checking one way radio button is selected or not
		Boolean selectValidation=driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).isSelected();
		Assert.assertTrue(selectValidation);
		//Return date calendar is disabled
		Boolean enableValidation=driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled();
		System.out.println("Calendar status is: "+enableValidation);
		//Wrong way of validation
		Assert.assertTrue(enableValidation);
		String attributeData=driver.findElement(By.cssSelector(".picker-second")).getAttribute("style");
		if(attributeData.contains("1"))
		{
			System.out.println("Calendar is Enabled");
		}
		else {
				System.out.println("Calendar is Disabled");
		}
		
		//Selecting current date from calendar
		driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	}
}
