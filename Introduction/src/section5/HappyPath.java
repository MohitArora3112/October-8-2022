package section5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HappyPath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//findElement by id
		String Password=getPassword(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		String userName="rahul";
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		//findElement by name
		driver.findElement(By.name("inputPassword")).sendKeys(Password);
		//findElement by className
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		//findElement by tagName
		System.out.println(driver.findElement(By.tagName("p")).getText());
		String successMessage=driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(successMessage,"You are successfully logged in.");
		
		String loginUser=driver.findElement(By.xpath("//div/h2")).getText();
		Assert.assertEquals(loginUser, "Hello "+userName+",");
		
		System.out.println(driver.findElement(By.xpath("//div/h1")).getText());
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		System.out.println("Logged out Successfully.");		

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@class,'forgot-pwd-container')]/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(1000);
		
		String pwdMessage=driver.findElement(By.className("infoMsg")).getText();
		String[] pwd=pwdMessage.split("'");
		String[] pass=pwd[1].split("'");
		System.out.println("Extracted Password is: "+pass[0]);
		
		return pass[0];
	}

}
