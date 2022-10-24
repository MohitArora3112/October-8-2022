package section17;

import org.testng.annotations.Test;

public class CarLoanLogin {

	@Test
	public void mobileLoginCarLoan()
	{
		System.out.println("Mobile login Successful");
	}
	
	@Test(groups={"smoke"})
	public void apiLoginCarLoan()
	{
		System.out.println("API login Successful");
	}
	
	@Test
	public void webLoginCarLoan()
	{
		System.out.println("Web login Successful");
	}
	
	@Test
	public void mobileAppLoginCarLoan()
	{
		System.out.println("mobile app login Successful");
	}
}
