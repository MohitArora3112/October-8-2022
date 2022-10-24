package section2;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EcommerceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));	
		
		String[] name= {"Cucumber","Brinjal","Apple","Pears"};
		List<String> vegName=Arrays.asList(name);
		
		List<WebElement> option=driver.findElements(By.cssSelector(".product-name"));
		int k=0;
		for(int i=0;i<option.size();i++)
		{
			String[] vegeName=option.get(i).getText().split(" -");
			if(vegName.contains(vegeName[0]))
			{
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
				k++;
				if(vegName.size()==k)
				{
					break;
				}
			}
		}
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.cssSelector(".cart-preview.active button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".promoInfo")));
		Assert.assertEquals("Code applied ..!",driver.findElement(By.cssSelector(".promoInfo")).getText());
		driver.findElement(By.cssSelector(".products button")).click();
	}
}
