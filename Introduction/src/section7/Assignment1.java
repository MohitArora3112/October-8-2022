package section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Question1
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Boolean selectValidation=driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected();
		Assert.assertTrue(selectValidation);
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Boolean unselectValidation=driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected();
		Assert.assertFalse(unselectValidation);
		
		//Question2
		int checkboxCount=driver.findElements(By.xpath("//*[@type='checkbox']")).size();
		Assert.assertEquals(3, checkboxCount);
	}

}
