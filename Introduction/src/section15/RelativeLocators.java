package section15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name=driver.findElement(By.name("name"));
		String labelName=driver.findElement(with(By.tagName("label")).above(name)).getText();
		System.out.println("Name Label is: "+labelName);
		
		WebElement labelPassword=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(labelPassword)).click();
		
		WebElement labelText=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(labelText)).click();
		
		WebElement checkboxClick=driver.findElement(By.cssSelector("#inlineRadio1"));
		String radiobtnText=driver.findElement(with(By.tagName("label")).toRightOf(checkboxClick)).getText();
		
		System.out.println("Label for toRightOf method is: "+radiobtnText);;
	}
}
