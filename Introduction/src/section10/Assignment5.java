package section10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();

		WebElement mainFrame=driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(mainFrame);
		
		WebElement nestedFrame=driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame(nestedFrame);
		
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
	}

}
