package section14;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Mohit Arora\\SeleniumLearningData\\BrowserDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector(".table.table-bordered th:nth-child(1)")).click();
//		driver.findElement(By.cssSelector(".table.table-bordered th:nth-child(1)")).click();
		List<WebElement> veggies=driver.findElements(By.cssSelector(".table.table-bordered td:nth-child(1)"));
		
		List<String> enhanceLoop=new ArrayList<String>();
		for(WebElement veg:veggies)
		{
			enhanceLoop.add(veg.getText());
		}
		System.out.println("Enhance loop List is: "+enhanceLoop);
		
		List<String> newList=veggies.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList=newList.stream().sorted().collect(Collectors.toList());		
		
		Assert.assertTrue(newList.equals(sortedList));
		
		List<String> price;
		do
		{
			List<WebElement> veg=driver.findElements(By.cssSelector(".table.table-bordered td:nth-child(1)"));
			price=veg.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggies(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1)
			{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
	}

	private static String getPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
}
