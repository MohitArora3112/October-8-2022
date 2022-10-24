package handsOnPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Section15 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameField=driver.findElement(By.name("name"));
		nameField.sendKeys("Vinay");
		File src=nameField.getScreenshotAs(OutputType.FILE);
		File destFile=new File("D:\\Mohit Arora\\SeleniumLearning\\Introduction\\screenshot"+"\\Namefield.jpg");
		FileUtils.copyFile(src, destFile);
		
		System.out.println(nameField.getRect().getHeight());
		System.out.println(nameField.getRect().getWidth());
		System.out.println(nameField.getRect().getDimension());
		
		nameField.clear();
		WebElement labelEmail=driver.findElement(By.cssSelector(".form-group:nth-child(2) label"));
		driver.findElement(with(By.tagName("input")).above(labelEmail)).sendKeys("Jatin");
		
		driver.findElement(with(By.tagName("input")).below(labelEmail)).sendKeys("test@test.com");
		
		//Multiple Windows
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);
		List<WebElement> linkSecondColumn=driver.findElements(By.cssSelector(".gf-t td:nth-child(2) a"));
		String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(int i=0;i<linkSecondColumn.size();i++) {
			linkSecondColumn.get(i).sendKeys(clickOnLink);
		}
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String windowId=it.next();
			driver.switchTo().window(windowId);
			System.out.println("Window Title is: "+driver.getTitle());
			
		}
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> newWindow=driver.getWindowHandles();
		Iterator<String> its=newWindow.iterator();
		String childId=its.next();
		String parentId=its.next();
		driver.switchTo().window(childId);
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		
		
		}
}
