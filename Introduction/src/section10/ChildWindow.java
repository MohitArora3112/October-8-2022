package section10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows=driver.getWindowHandles(); //ParentId, ChildId
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		
		//String emailId=driver.findElement(By.cssSelector(".im-para.red a")).getText();
		String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" with")[0];
		
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		

	}

}
