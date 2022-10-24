package section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#name")).sendKeys("Mohit");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		Thread.sleep(1000);
		String message=driver.switchTo().alert().getText();
		Assert.assertEquals("Hello Mohit, share this practice page and share your knowledge", message);
		driver.switchTo().alert().accept();
		

	}

}
