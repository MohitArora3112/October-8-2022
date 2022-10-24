package section12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,670)");
		
		int rowCount=driver.findElements(By.cssSelector("#product:nth-child(2) tr")).size();
		System.out.println("Total no. of rows: "+rowCount);
		
		int columnCount=driver.findElements(By.cssSelector("#product:nth-child(2) tr:nth-child(1) th")).size();
		System.out.println("Total no. of columns: "+columnCount);
		
		List<WebElement> list=driver.findElements(By.cssSelector("#product:nth-child(2) tr:nth-child(3) td"));
		
		System.out.println(list.get(0).getText()+"		"+list.get(1).getText()+"		"+list.get(2).getText());
	}

}
