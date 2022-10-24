package section17;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lecture1 {
	
	//TestNG will act as Java compiler for you. So, there is no need of main method. TestNG itself is based of Java.
	//You need to have @Test annotation followed by the method
	
	//Test Suite(Loan Department)
	//Test name(folder name, module name -> Car Loan, Personal Loan)
	//class -> contains our test cases(class files)
	
	@Test
	public void demoTest()
	{
		System.out.println("This is a demo test");
	}
	
	@Test(groups={"smoke"})
	public void secondTest()
	{
		System.out.println("This is second test");
	}
	
	@AfterTest
	public void afterMethodTest()
	{
		System.out.println("After Test Executed");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method Executed");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method Executed");
	}

}
