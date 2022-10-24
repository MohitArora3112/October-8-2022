package handsOnPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Getting price based on itemName in a webPage
//		driver.findElement(By.cssSelector("#search-field")).sendKeys("Ri");
//		List<WebElement> firstColumnElement=driver.findElements(By.cssSelector(".table.table-bordered td:nth-child(1)"));
//		for(int i=0;i<firstColumnElement.size();i++)
//		{
//			if(firstColumnElement.get(i).getText().equalsIgnoreCase("Brinjal"))
//			{
//				System.out.println(firstColumnElement.get(i).findElement(By.xpath("following-sibling::td")).getText());			
//			}
//		}
		
		//Pagination
		String price="";
		do
		{
		List<WebElement> firstColumnElements=driver.findElements(By.cssSelector(".table.table-bordered td:nth-child(1)"));
		for(int i=0;i<firstColumnElements.size();i++)
		{
			if(!firstColumnElements.get(i).getText().equalsIgnoreCase("Almond"))
			{
				driver.findElement(By.xpath("//button[text()='Next']")).click();
			}
			else
			{
				System.out.println(firstColumnElements.get(i).findElement(By.xpath("following-sibling::td")).getText());
				price=firstColumnElements.get(i).findElement(By.xpath("following-sibling::td")).getText();
			}	
		}
		}while(price.equalsIgnoreCase(""));
		
	}

}
