package handsOnPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Alert Hands-on
		driver.findElement(By.id("name")).sendKeys("Vinay");
		driver.findElement(By.id("alertbtn")).click();
		String alertText=driver.switchTo().alert().getText();
		System.out.println("Alert text is: "+alertText);
		driver.switchTo().alert().accept();
		
		//dropdown Hands-on
		driver.navigate().to("https://www.makemytrip.com/");
		Thread.sleep(10000);
		
//		if(driver.findElement(By.cssSelector(".close")).isDisplayed())
//		{
//			driver.findElement(By.cssSelector(".close")).click();
//		}
		if(driver.findElement(By.cssSelector(".langCardClose")).isDisplayed())
		{
			driver.findElement(By.cssSelector(".langCardClose")).click();
		}
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).sendKeys("Del");
		Thread.sleep(3000);
		List<WebElement> uiElement=driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
		for(int i=0;i<uiElement.size();i++)
		{
			System.out.println(uiElement.get(i).getText());
			if(uiElement.get(i).getText().equalsIgnoreCase("DED"))
			{
				uiElement.get(i).click();
				break;
			}
		}
		

	}

}
