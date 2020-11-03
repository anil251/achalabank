package com.selenium.automation.achala.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TCActivity implements ITestListener {
	
	
	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Finish The Excution");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Start The Excution");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case Is Failed But Success Percentage " +result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Is Failed " +result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The Test Case Is Skiped " +result.getName()) ;
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Case Is Started :" +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The Test Case Is Success :"+result.getName());
		
	}	
	
	
}
	 

