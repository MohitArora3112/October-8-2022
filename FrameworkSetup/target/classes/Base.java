package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;	
		public WebDriver initializeDriver() throws IOException
		{
			FileInputStream fis=new FileInputStream("D:\\Mohit Arora\\SeleniumLearning\\FrameworkSetup\\testdata\\Testdata.properties");
			prop=new Properties();
			prop.load(fis);
			
			String Path=System.getProperty("user.dir")+"//BrowserDrivers//";
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", Path+"chromedriver.exe");
				driver=new ChromeDriver();
			}else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", Path+"geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver", Path+"msedgedriver.exe");
				driver=new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return driver;
	}
		

		public String getScreenshot(String testName,WebDriver driver) throws IOException
		{
			System.out.println(testName);
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destFile=System.getProperty("user.dir")+"\\screenshot\\"+testName+".png";
			FileUtils.copyFile(src, new File(destFile));
			return destFile;
		}
}
