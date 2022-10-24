package section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Enter username
		driver.findElement(By.name("name")).sendKeys("Mohit");
		//Enter email
		driver.findElement(By.name("email")).sendKeys("aroram3112@gmail.com");
		//Enter password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Mohit@5678");
		//Select checkbox
		driver.findElement(By.id("exampleCheck1")).click();
		//Selecting Student radio button
		driver.findElement(By.id("inlineRadio1")).click();
		//Selecting dropdown value as male
		Select s=new Select(driver.findElement(By.cssSelector("#exampleFormControlSelect1")));
		s.selectByIndex(1);
		//Enter Calendar date
		driver.findElement(By.name("bday")).sendKeys("22/07/1993");
		//Click on Submit button
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		Thread.sleep(1000);
		
		String message=driver.findElement(By.cssSelector(".alert-success")).getText();
		System.out.println(message);
	}
}
