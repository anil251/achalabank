package com.selenium.automation.achala.BaseEngine;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.automation.achala.Utilities.DriverValues;
import com.selenium.automation.achala.Utilities.ScreenShortUtilities;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class BaseTest {
	
	private static WebDriver driver;  
	private static String currentdir;
	private static String tcname;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	private ATUTestRecorder recorder;
	
	@BeforeSuite
	public void openBrowser() {
		currentdir = System.getProperty("user.dir");		
		System.setProperty(DriverValues.chromekey,DriverValues.chromevalue);
		driver = new ChromeDriver();
		init();
		

	}
	@BeforeTest
	public void initReports() {
		extentReports = new ExtentReports("H:\\Workspace\\Achala_Bank\\ExtentReports\\reports.html");
		

	}
	public void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		
	}
	@AfterMethod
	public void AfterTCExcution(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("THE TEST CASE IS SUCCESS : "+result.getName());
			extentTest.log(LogStatus.PASS, "THE TEST CASE IS PASS :"+tcname);
			ScreenShortUtilities.GetPassed_screenShot(tcname);
			
		}
		if (result.getStatus()==ITestResult.FAILURE) {			 
			System.out.println("THE TEST CASE IS FAILURE :"+result.getName()+"Reason Is : "+result.getThrowable());
			ScreenShortUtilities.GetFailed_screenShot(tcname);
			extentTest.log(LogStatus.FAIL, "TE TEST CASE IS FAILED :"+tcname);				
			String screenshotPath = ScreenShortUtilities.GetFailed_screenShot(tcname);
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenshotPath));
			
			extentTest.log(LogStatus.FAIL,result.getThrowable());
		}
		if (result.getStatus()==ITestResult.SKIP) {
			System.out.println("THE TEST CASE IS SKIP :"+result.getName()+"Reason Is : "+result.getThrowable() );
			ScreenShortUtilities.GetSkiped_screenShot(tcname);			
			extentTest.log(LogStatus.SKIP, "THE TEST CASE IS SKIPED :"+tcname);
						
		}
		extentReports.endTest(extentTest);
		extentReports.flush();
		
		 

	}
	
	
	
	
	@BeforeMethod
	public void BeforeTCExcution(Method method) throws ATUTestRecorderException {
		tcname = method.getName();
		System.out.println("THE PRESENT TEST CASE NAME IS : " +tcname);
		//SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yy-MM-DD  HH-MM-SS");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd  HH-mm-ss");
		Date date = new Date();
		try {
		 recorder = new ATUTestRecorder("H:\\Workspace\\Achala_Bank\\Execution_Videos", "RecordedVideo-",false);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		recorder.start();
		extentTest =extentReports.startTest(tcname);
		extentTest.log(LogStatus.INFO, "The Currently Executing Test Case is :"+tcname);

	}
	@AfterTest
	public void generateReports() throws ATUTestRecorderException {
	Optional optional = Optional.ofNullable(extentReports);
	if (optional.isPresent()) 
	{
		extentReports.endTest(extentTest);
		extentReports.flush();
		extentReports.close();
		
	}
	else {
		System.out.println("Extents Reports Pointing To Null");
		
	  }
	 //extentReports.close();
	recorder.stop();

	}
	
	@AfterSuite
	public static WebDriver getDriver() {
		return driver;		
	}
	
	public static String getCurrentDir() {
		return currentdir;
	}
	
	public static  String getTcName() {
		return tcname;
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
	
	
	

}
