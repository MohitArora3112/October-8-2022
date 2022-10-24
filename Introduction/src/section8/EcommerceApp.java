package section8;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> itemsName=driver.findElements(By.cssSelector(".product-name"));
		String[] name= {"Brocolli","Beans","Potato"};

		List<String> al=Arrays.asList(name);
		int k=0;
		for(int i=0;i<itemsName.size();i++)
		{
			String[] vegName=itemsName.get(i).getText().split(" - ");
//			System.out.println(vegName[0]);
//			System.out.println(vegName[1]);
//			format it to get actual name and then use
//			String aname=vegName[0].trim();
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

}
