package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;

	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		String projectPath=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(projectPath+"\\src\\main\\java\\resources\\TestData.properties");
		prop=new Properties();
		prop.load(fis);
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\browserDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"\\browserDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", projectPath+"\\browserDrivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
