package com.selenium.automation.achala.bussinesscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.automation.achala.BaseEngine.BaseTest;
import com.selenium.automation.achala.Utilities.POJOReaders;


public class Login extends BaseTest {
	public  String username;
	public  String password;
	  
	  @Test(priority = 0)
		public void bank_account_login() throws Exception {
		  
			getExtentTest().log(LogStatus.INFO, "BROWSER IS OPENED");
	 		getDriver().get(POJOReaders.getconfPropertiesReaders().getValueForKey("achala_url"));
	 		getExtentTest().log(LogStatus.INFO, "URL IS ENTERED AS :");
			WebElement email = getDriver().findElement(By.name("uid")); 
			
			//email.sendKeys(ExcelReader.username);			
			email.sendKeys(POJOReaders.getconfPropertiesReaders().getValueForKey("user_name"));
			getExtentTest().log(LogStatus.INFO, "Email Entered");
			WebElement pwd = getDriver().findElement(By.name("password"));
			getExtentTest().log(LogStatus.INFO, "PASSWORD ENTERED");
			//pwd.sendKeys(ExcelReader.password);			
			pwd.sendKeys(POJOReaders.getconfPropertiesReaders().getValueForKey("pwd"));
			WebElement btn = getDriver().findElement(By.name("btnLogin"));
			
			btn.click();
			getExtentTest().log(LogStatus.INFO, "LOGIN BUTTON CLICKED");
			String actualTitle = getDriver().getTitle();
			if (actualTitle.contains(POJOReaders.getconfPropertiesReaders().getValueForKey("exped_title"))) {
					    System.out.println("Test case: Passed");
			} 
			else {
					    System.out.println("Test case : Failed");
					    System.out.println("Test case : Failed");
			}
			/*
			 * String expectedTitle = "Guru99 Bank Manager HomePage"; String actualTitle =
			 * getDriver().getTitle(); assertEquals(actualTitle,expectedTitle);
			 */
		  
	  }
	  
	  
		
	
	
}
