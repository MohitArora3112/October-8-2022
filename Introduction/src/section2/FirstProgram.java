package section2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating object of ChromeDriver class
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver cdriver=new ChromeDriver();
		cdriver.get("https://rahulshettyacademy.com/");
		
		//SelectorHub plugin for Edge and Firefox browser
		//Creating object of EdgeDriver class
		System.setProperty("webdriver.edge.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\EdgeDriver\\msedgedriver.exe");
		WebDriver edriver=new EdgeDriver();
		edriver.get("https://rahulshettyacademy.com/");
		
		//Creating object of FirefoxDriver class
		System.setProperty("webdriver.gecko.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\GeckoDriver\\geckodriver.exe");
		WebDriver fdriver=new FirefoxDriver();
		fdriver.get("https://rahulshettyacademy.com/");
		fdriver.manage().window().maximize();
		System.out.println("WebPage Title is: "+fdriver.getTitle());
		System.out.println("WebPage Url is: "+fdriver.getCurrentUrl());
		
		fdriver.close();	


	}

}
