package section17;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture2 {
	@BeforeClass
	public void beforeClassMethod()
	{
		System.out.println("Before Class Executed");
	}
	@BeforeTest
	public void beforeFunctionalityTest()
	{
		System.out.println("Before Test Executed");
	}
	@Test(groups={"smoke"})
	public void thirdTest()
	{
		System.out.println("This is my 3rd test");
	}
	@BeforeSuite
	public void beforeSuitMethod()
	{
		System.out.println("Before Suit Method Executed");
	}
	@AfterSuite
	public void afterSuitMethod()
	{
		System.out.println("After Suit Method Executed");
	}
	@AfterClass
	public void afterClassMethod()
	{
		System.out.println("After Class Executed");
	}
}
