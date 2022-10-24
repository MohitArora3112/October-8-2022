package section2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class LinksValidation {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		//disabling URL alerts
		option.addArguments("--disable-notifications");
		//Any external plugin if you want to use
		option.addExtensions();
		//Handling SSL Certification
		option.setAcceptInsecureCerts(true);
		//Proxy Setup
		Proxy proxy=new Proxy();
		proxy.setHttpProxy(null);
		option.setCapability("proxy", proxy);
		//Changing the default download directory
		Map<String,Object> prefs=new HashMap<String,Object>();
		prefs.put("download.default_directory","");
		option.setExperimentalOption("Prefs", prefs);
		
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		WebElement footerSection=driver.findElement(By.cssSelector("#gf-BIG"));
//		List<WebElement> linkElement=footerSection.findElements(By.tagName("a"));
//		String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
//		for(WebElement option:linkElement)
//		{
//			option.sendKeys(clickOnLink);
//		}
//		Set<String> window=driver.getWindowHandles(); 
//		Iterator<String> it=window.iterator();
//		while(it.hasNext())
//		{
//			String windowId=it.next();
//			driver.switchTo().window(windowId);
//			System.out.println("Window title are: "+driver.getTitle());
//		}
		
		WebElement firstColumn=driver.findElement(By.cssSelector(".gf-t tr td:nth-child(2)"));
		List<WebElement> linkFirstColumn=firstColumn.findElements(By.tagName("a"));
		SoftAssert sa=new SoftAssert();
		for(int i=1;i<linkFirstColumn.size();i++)
		{
			String url=firstColumn.findElements(By.tagName("a")).get(i).getAttribute("href");
			String linkName=firstColumn.findElements(By.tagName("a")).get(i).getText();
			System.out.println(linkName+" "+ url);
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int code=conn.getResponseCode();
			System.out.println("Status Code is: "+code);
			sa.assertTrue(code<400, linkName+" link is broken");
		}
		sa.assertAll();
	}

}
