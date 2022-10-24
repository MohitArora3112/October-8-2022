package section17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Globalvariable {

	@Test
	public void getGlobalVariablevalues() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Mohit Arora\\SeleniumLearning\\TestNGProject\\TestData\\TestData.properties");
		prop.load(fis);
		
		System.out.println("URL is: "+prop.getProperty("URL"));
		System.out.println("Usename is: "+prop.getProperty("Username"));
		System.out.println("Password is: "+prop.getProperty("Password"));
		
		prop.setProperty("Username", "jatinlogin");
		System.out.println("Usename is: "+prop.getProperty("Username"));
		
		FileOutputStream fos=new FileOutputStream("D:\\Mohit Arora\\SeleniumLearning\\TestNGProject\\TestData\\TestData.properties");
		prop.store(fos, null);
	}
}
