package section7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpicejetE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");
		        
		//Set path for driver exe 
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");

		//Pass ChromeOptions instance to ChromeDriver Constructor
		WebDriver driver =new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-zso239")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector(".css-31dbjc4n.r-14lw9ot.r-11u4nky.r-z2wwpe.r-1phboty.r-rs99b7.r-1loqt21.r-13awgt0.r-ymttw5.r-tju18j.r-5njf8e.r-1otgn73 .css-1cwyjr8.r-homxoj.r-ubezar.r-10paoce.r-13qz1uu")).click();
		driver.findElement(By.cssSelector(".css-31dbjc4n.r-14lw9ot.r-11u4nky.r-z2wwpe.r-1phboty.r-rs99b7.r-1loqt21.r-13awgt0.r-ymttw5.r-tju18j.r-5njf8e.r-1otgn73 .css-1cwyjr8.r-homxoj.r-ubezar.r-10paoce.r-13qz1uu")).sendKeys("ag");
		Thread.sleep(1000);
		List<WebElement> list=driver.findElements(By.cssSelector(".css-1dbjc4n.r-19yat4t.r-1rt2jqs .css-76zvg2.r-1xedbs3.r-ubezar"));
		for(WebElement s:list)
		{
			if(s.getText().contains("ag"))
			{
				s.click();
				break;
			}
		}
		
		
		

	}

}
