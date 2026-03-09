package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.Projectspecificmethods;

public class MyListeners extends Projectspecificmethods implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test case PASSED is : " +result.getName());
		String screenshot="";
		try {
			screenshot=screenshot(result.getMethod().getMethodName());
			
		}catch(Exception e){
			e.printStackTrace();
		}

		test.addVideoFromPath(screenshot, "Pass screenshot");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test case FAILED is : " +result.getName());
		test.log(Status.PASS,"Test case FAILED cause is : " +result.getThrowable());
		String screenshot="";
		try {
			screenshot=screenshot(result.getMethod().getMethodName());
			
		}catch(Exception e){
			e.printStackTrace();
		}

		test.addVideoFromPath(screenshot, "Failure screenshot");

		
	}

}
