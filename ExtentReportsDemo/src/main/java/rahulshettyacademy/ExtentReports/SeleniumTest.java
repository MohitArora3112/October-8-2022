package rahulshettyacademy.ExtentReports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	static ExtentReports extent;
	static ExtentTest test;
	
	@BeforeClass
	public void beforeTest()
	{
		String path= System.getProperty("user.dir") + "\\reports\\index.html";
		extent = new ExtentReports(path);
		test=extent.startTest("SeleniumTest");
	}
	
	@Test
	public void firstSeleniumTest()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companions");
		System.out.println(driver.getTitle());
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	
	@Test
	public void secondSeleniumTest()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companions");
		System.out.println(driver.getTitle());
		test.log(LogStatus.FAIL, "secondTestFail");
	}
	
	@AfterClass
	public void afterTest()
	{
		extent.endTest(test);
		extent.flush();		
	}
}
