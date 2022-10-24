package section12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Ind");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN,Keys.ENTER);
		
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
//		List<WebElement> list=driver.findElements(By.cssSelector(".ui-menu-item div"));
//		
//		for(WebElement s:list) {
//			String country=s.getText();
//			if(country.equalsIgnoreCase("Finland"))
//			{
//				s.click();
//				break;
//			}			
//		}
		
	}
}
