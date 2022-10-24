package section17;

import org.testng.annotations.Test;

public class HelperAttribute {
	
	@Test(timeOut=4000)
	public void WebLogin()
	{
		System.out.println("WebLogin Successful.");
	}
	@Test(dependsOnMethods= {"WebLogin"})
	public void AppLogin()
	{
		System.out.println("AppLogin Successful.");
	}
	@Test(enabled=false)
	public void mobileLogin()
	{
		System.out.println("Mobile Login Successful.");
	}

}
