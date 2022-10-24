package resources;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReporterReport {
	
	static ExtentReports extent;
	
	public static ExtentReports beforeTest()
	{
		String path= System.getProperty("user.dir") + "\\reports\\index.html";
		extent = new ExtentReports(path);
		extent.addSystemInfo("Tester","Mohit Arora");
		extent.assignProject("SIRIUS Automation");
		
		return extent;
	}

}
