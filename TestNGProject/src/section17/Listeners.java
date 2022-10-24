package section17;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	//ITestResult --> Describe the result of a test
    @Override		
    public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        System.out.println("On Finish Listener Executed");
    }		

    @Override		
    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
        		System.out.println("Take Screenshot after the test case failure"+result.getName());
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
        System.out.println("On Success Listener Executed");
    }	

}
