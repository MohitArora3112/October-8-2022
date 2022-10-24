package section2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

public class MakeMyTripAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");

		
		driver.findElement(By.cssSelector(".fswTabs.latoBlack.greyText li:nth-child(1)")).click();
		Boolean flag=driver.findElement(By.cssSelector(".langCardClose")).isDisplayed();
		if(flag)
		{
			driver.findElement(By.cssSelector(".langCardClose")).click();
		}
		
		//Entering from City
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).sendKeys("Del");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pushRight.font14.lightGreyText.latoBold")));
		
		List<WebElement> srcCity=driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
		for(WebElement city:srcCity)
		{
			if(city.getText().equalsIgnoreCase("del"))
			{
				city.click();
				break;
			}
		}
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).sendKeys("jai");
		List<WebElement> destCity=driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
		for(WebElement city:destCity)
		{
			if(city.getText().equalsIgnoreCase("pnq"))
			{
				city.click();
				break;
			}
		}
		
		//Selecting Departure date
		driver.findElement(By.cssSelector(".fsw div div:nth-child(4)")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fsw div div:nth-child(4)")));
		while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText().equalsIgnoreCase("November 2022")) 
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		List<WebElement> dateWeb=driver.findElements(By.xpath("(//div[@class='DayPicker-Body'])[1] //div[@class='dateInnerCell']/p[1]"));
		for(WebElement date:dateWeb)
		{
			if(date.getText().equalsIgnoreCase("13"))
			{
				date.click();
				break;
			}
		}
		
		//Select Student Fare radio button
//		driver.findElement(By.cssSelector(".specialFareNew li:nth-child(4) div p:nth-child(1)")).click();
		
		driver.findElement(By.cssSelector("label[for='travellers']")).click();
		driver.findElement(By.cssSelector("li[data-cy='adults-4']")).click();
		driver.findElement(By.cssSelector("li[data-cy='travelClass-2']")).click();
		driver.findElement(By.cssSelector(".primaryBtn.btnApply.pushRight")).click();
		driver.findElement(By.cssSelector(".makeFlex.vrtlCenter a")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".listingRhs .font24.blackFont.whiteText.appendBottom20.journey-title")));
		String message=driver.findElement(By.cssSelector(".listingRhs .font24.blackFont.whiteText.appendBottom20.journey-title")).getText();
		Assert.assertEquals("Flights from New Delhi to Pune", message);
		
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		WebElement foo=fwait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("")).isDisplayed())
				{
					return driver.findElement(By.cssSelector(""));
				}
				else
					return null;	
			}
		});
		
	}

}
