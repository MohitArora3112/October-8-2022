package section11;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companions");
		
		//Selecting Month and Year
		driver.findElement(By.cssSelector("#travel_date")).click();;
		while(!driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).getText().equalsIgnoreCase("December 2022"))
		{
				driver.findElement(By.cssSelector(".datepicker-days .next")).click();
		}
		
		List<WebElement> list=driver.findElements(By.cssSelector(".day"));
		
		//Handling date in Calendar
		for (int i=0;i<list.size();i++)
		{
			String date=driver.findElements(By.cssSelector(".day")).get(i).getText();
			if(date.equalsIgnoreCase("23"))
			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}
		


	}

}
