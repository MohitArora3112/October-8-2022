package section5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//findElement by id
		driver.findElement(By.id("inputUsername")).sendKeys("Mohit");
		//findElement by name
		driver.findElement(By.name("inputPassword")).sendKeys("Schw@b3112");
		//findElement by className
		driver.findElement(By.className("signInBtn")).click();
		//findElement by cssSelector
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		//findElement by linkText
		driver.findElement(By.linkText("Forgot your password?")).click();
		//findElement By xPath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mohit");
		//Try xPath by Index
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("aroramohit3112@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//Try cssSelector by Index
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("aroram3112@gmail.com");
		//Parent to Child Traversing - xPath
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9034813681");
		//findElement by cssSelector
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//Parent to Child Traversing by cssSelector
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//Try xPath with RE
		driver.findElement(By.xpath("//button[contains(@class,'go-to-login')]")).click();
		Thread.sleep(1000);
		//Try cssSelector with RE
		driver.findElement(By.cssSelector("*[value*='rmbrUser']")).click();
		
		
		
		
		
		
	}

}
