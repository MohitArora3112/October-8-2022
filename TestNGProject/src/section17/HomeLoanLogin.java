package section17;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeLoanLogin {

	@Test
	public void mobileLoginHomeLoan()
	{
		System.out.println("Mobile login Successful");
	}
	
	@Test(groups={"smoke"})
	public void apiLoginHomeLoan()
	{
		System.out.println("API login Successful");
	}
	
	@Test @Parameters({"URL","Username","Password"})
	public void webLoginHomeLoan(String Urlname, String Username, String Password)
	{
		System.out.println("Web login Successful");
		System.out.println("URL is: "+Urlname);
		System.out.println("Username is: "+Username);
		System.out.println("Password is: "+Password);
	}
	
	@Test(groups={"smoke"})
	public void mobileAppLoginHomeLoan()
	{
		System.out.println("mobile app login Successful");
	}
}
