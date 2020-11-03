package com.selenium.automation.achala.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.selenium.automation.achala.BaseEngine.BaseTest;


public interface ScreenShortUtilities {
	public static String GetFailed_screenShot(String tcname) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String imagepath =BaseTest.getCurrentDir()+"\\ExtentReports\\"+tcname+dateName+".jpeg";
		TakesScreenshot takesScreenshot = (TakesScreenshot)BaseTest.getDriver();
		File sourse =takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourse, new File(imagepath));
		return imagepath;
		
		
	}
	public static String GetPassed_screenShot(String tcname) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String imagepath =BaseTest.getCurrentDir()+"\\Passed_Test_Screenshorts\\"+tcname+dateName+".jpeg";
		TakesScreenshot takesScreenshot = (TakesScreenshot)BaseTest.getDriver();
		File sourse =takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourse, new File(imagepath));
		return imagepath;
		
	}
	public static String GetSkiped_screenShot(String tcname) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String imagepath =BaseTest.getCurrentDir()+"\\Skiped_Test_Screenshorts\\"+tcname+dateName+".jpeg";
		TakesScreenshot takesScreenshot = (TakesScreenshot)BaseTest.getDriver();
		File sourse =takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourse, new File(imagepath));
		return imagepath;
		
	}

}
