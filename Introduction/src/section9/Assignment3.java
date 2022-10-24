package section9;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String username="rahulshettyacademy";
		String password="learning";
		Assignment3.loginToApplication(driver,username, password);
		
		String[] itemsNeeded= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		Assignment3.placeOrder(driver,itemsNeeded);
	}
	public static void loginToApplication(WebDriver driver, String username, String password) throws InterruptedException
	{
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		WebElement userType = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(userType);
		dropdown.selectByValue("consult");
		
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();	
	}
	public static void placeOrder(WebDriver driver,String[] itemsNeeded)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".nav-link.btn.btn-primary")));
		
		List<WebElement> list=driver.findElements(By.cssSelector(".card-title a"));
		List<String> items=Arrays.asList(itemsNeeded);
		int k=0;
		for(int i=0;i<list.size();i++)
		{
			String name=driver.findElements(By.cssSelector(".card-title a")).get(i).getText();
			if(items.contains(name))
			{
				driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
				k++;
			}
			if(items.size()==k)
			{
				break;
			}
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
	}
}
