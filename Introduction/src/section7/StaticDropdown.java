package section7;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement currencyDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//Any dropwdown with a tag select is called static dropdown
		Select s=new Select(currencyDropdown);
		s.selectByIndex(0);
		Thread.sleep(1000);
		s.selectByValue("AED");
		Thread.sleep(1000);
		s.selectByVisibleText("USD");	
		
		//selecting adult from the dropdown
		driver.findElement(By.id("divpaxinfo")).click();
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter number of Adults: ");
//		int num=sc.nextInt();
//		for(int i=0;i<2;i++)
//		{
//			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
//		}
		int i=1;
		while(i<3)
		{
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		
		//Handling Dynamic Dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[1]")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTNR a[value='DEL']")).click();
		
		//AutoSuggestive Dropdowns
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> countriesName=driver.findElements(By.cssSelector(".ui-menu-item .ui-corner-all"));
		for(WebElement option:countriesName)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
	}
}
