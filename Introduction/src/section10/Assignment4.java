package section10;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		
		driver.switchTo().window(childId);
		String childPageText=driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println("Child Page Text is: "+childPageText);
		
		driver.switchTo().window(parentId);
		String parentPageText=driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println("Parent Page Text is: "+parentPageText);
	}
}
