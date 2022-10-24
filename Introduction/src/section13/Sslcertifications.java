package section13;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sslcertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		//Handling Insecure Certifications - like SSL certifications
		option.setAcceptInsecureCerts(true);
		//Adding Extensions
		option.addExtensions();
		//Setting Proxy
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		option.setCapability("proxy", proxy);
		//Browser location
		option.addArguments("--disable-notifications");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://expired.badssl.com/");
		
		
	}

}
