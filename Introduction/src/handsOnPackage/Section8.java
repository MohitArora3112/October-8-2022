package handsOnPackage;

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

public class Section8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] itemNeeded= {"Tomato","Mango","Walnuts"};
		
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<String> al=Arrays.asList(itemNeeded);
		List<WebElement> uiElement=driver.findElements(By.cssSelector(".product-name"));
		int k=0;
		for(int i=0;i<uiElement.size();i++)
		{
			
			String[] itemName=uiElement.get(i).getText().split(" -");

			if(al.contains(itemName[0]))
			{
				System.out.println(i);
				System.out.println(itemName[0]);
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
				k++;
				if(al.size()==k)
				{
					break;
				}
			}
			
		}
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.cssSelector(".cart-preview.active button")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		Assert.assertEquals("Code applied ..!",driver.findElement(By.cssSelector(".promoInfo")).getText());
		driver.findElement(By.xpath("//span[@class='discountPerc']/following-sibling::button")).click();
		
		WebElement countryName=driver.findElement(By.cssSelector(".wrapperTwo select"));
		Select option=new Select(countryName);
		option.selectByValue("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
//		
		
		

	}

}
