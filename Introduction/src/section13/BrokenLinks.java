package section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert sa=new SoftAssert();
		
		//Java methods call those URL's and get you the status code
		WebElement footer=driver.findElement(By.cssSelector("#gf-BIG"));
		List<WebElement> list=footer.findElements(By.tagName("a"));
		for(int i=0;i<list.size();i++)
		{
			String url=footer.findElements(By.tagName("a")).get(i).getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode=conn.getResponseCode();
			sa.assertTrue(statusCode<400, footer.findElements(By.tagName("a")).get(i).getText()+ "link is broken");
		}
		sa.assertAll();
	}
}
