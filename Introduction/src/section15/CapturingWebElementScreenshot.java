package section15;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingWebElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("D:\\Mohit Arora\\SeleniumLearningData\\Screenshot\\Screenshot.jpg");
		FileUtils.copyFile(src, destFile);
		
		WebElement nameInput=driver.findElement(By.name("name"));
		nameInput.sendKeys("TestIng Project");
		File src1=nameInput.getScreenshotAs(OutputType.FILE);
		File destFile1=new File("D:\\Mohit Arora\\SeleniumLearningData\\Screenshot\\Screenshot1.jpg");
		FileUtils.copyFile(src1, destFile1);
		
	}

}
