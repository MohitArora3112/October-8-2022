package section12;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableScrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> list=driver.findElements(By.cssSelector("#product td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<list.size();i++)
		{
			String num=driver.findElements(By.cssSelector("#product td:nth-child(4)")).get(i).getText();
			int number=Integer.parseInt(num);
			sum=sum+number;
		}	
		System.out.println("Sum is: "+sum);
		
		String[] total=driver.findElement(By.cssSelector(".totalAmount")).getText().split(": "); 
		Assert.assertEquals("296", total[1]);
		
//		Scanner sc=new Scanner(System.in);
//		int num=sc.nextInt();
//		String name=sc.next();
//		System.out.println(name);
		
	}
}
