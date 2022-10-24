package section11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#checkBoxOption3")).click();
		String checkboxLabel=driver.findElement(By.xpath("//input[@id='checkBoxOption3']/parent::label")).getText().trim();
		System.out.println("Selected checbox Label is: "+checkboxLabel);
		
		Select s=new Select(driver.findElement(By.name("dropdown-class-example")));
		s.selectByVisibleText(checkboxLabel);
		
		driver.findElement(By.id("name")).sendKeys(checkboxLabel);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertMessage=driver.switchTo().alert().getText();
		if(alertMessage.contains(checkboxLabel))
		{
			System.out.println("Text is present");
		}
		else
			System.out.println("Text is not present");
		driver.switchTo().alert().accept();
	}

}
