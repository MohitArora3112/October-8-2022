package section10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frameId=driver.findElement(By.cssSelector(".demo-frame"));
		//driver.switchTo().frame(frameId);
		driver.switchTo().frame(0);
		
		WebElement sourceId=driver.findElement(By.cssSelector("#draggable"));
		WebElement targetId=driver.findElement(By.cssSelector("#droppable"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(sourceId, targetId).build().perform();
		
		//To move out of the frame
		driver.switchTo().defaultContent();	
	}

}
