package section10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		
		WebElement signinText=driver.findElement(By.cssSelector("#nav-tools:nth-child(2) a:nth-child(2)"));
		Actions  act=new Actions(driver);
		act.moveToElement(signinText).build().perform();
		
		Thread.sleep(2000);
		
		WebElement searchTextBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		act.moveToElement(searchTextBox).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).doubleClick().build().perform();
		
		Thread.sleep(2000);
		
//		WebElement signinSecurely=driver.findElement(By.cssSelector(".a-button-inner"));
		act.moveToElement(signinText).contextClick().build().perform();
		
	}

}
