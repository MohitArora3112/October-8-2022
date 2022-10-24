package section17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider="getData")
	public void loginDetails(String Username, String Password)
	{
		System.out.println("Username is: "+Username);
		System.out.println("Password is: "+Password);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="Mohit";
		obj[0][1]="Schw@3112";
		
		obj[1][0]="Vinay";
		obj[1][1]="Password123";
				
		obj[2][0]="Sachin";
		obj[2][1]="Password456";
		
		return obj;
	}

}
