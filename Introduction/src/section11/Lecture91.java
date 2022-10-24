package section11;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lecture91 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//Count number of link in a webpage
		System.out.println("LinkCount on the Entrie Webpage is: "+driver.findElements(By.tagName("a")).size());
		
		//limiting the webdriver scope to get links count in particular section
		WebElement divPart=driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println("LinkCount in Footer Section is: "+divPart.findElements(By.tagName("a")).size());
		
		//counting number of links in a column
		WebElement linkCount=divPart.findElement(By.cssSelector(".gf-t tr td:nth-child(1) ul"));
		int count=linkCount.findElements(By.tagName("a")).size();
		System.out.println("LinkCount in First Column is: "+linkCount.findElements(By.tagName("a")).size());
		//Click on each link and check new window is opened or not
		for(int i=1;i<count;i++)
		{
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			linkCount.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			String windowId=it.next();
			driver.switchTo().window(windowId);
			System.out.println("Windows Title is: "+driver.getTitle());
		}
		
	}

}
