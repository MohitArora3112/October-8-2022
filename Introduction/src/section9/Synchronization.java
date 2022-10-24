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
import org.testng.Assert;

public class Synchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
		String[] name= {"Brocolli","Beans","Potato"};
		Synchronization sync=new Synchronization();
		sync.addItemsToCart(driver,name);
		sync.placeOrder(driver);	
	}
	public void addItemsToCart(WebDriver driver,String[] name)
	{
		List<WebElement> itemsName=driver.findElements(By.cssSelector(".product-name"));
		List<String> al=Arrays.asList(name);
		int k=0;
		for(int i=0;i<itemsName.size();i++)
		{
			String[] vegName=itemsName.get(i).getText().split(" - ");
			if(al.contains(vegName[0]))
			{
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
				k++;
				if(al.size()==k)
				{
					break;
				}
			}
		}
		
		//Click on proceed to checkout
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.cssSelector(".cart-preview.active .action-block button")).click();
	}
	public void placeOrder(WebDriver driver)
	{
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		String message=driver.findElement(By.cssSelector(".promoInfo")).getText();
		Assert.assertEquals("Code applied ..!",message);
		
		driver.findElement(By.xpath("//div[@class='products']/div/button")).click();	
		
		WebElement countryDropdown=driver.findElement(By.cssSelector("select"));
		Select country=new Select(countryDropdown);
		country.selectByValue("India");
		
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.cssSelector(".wrapperTwo button")).click();
	}
}
