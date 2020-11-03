package com.selenium.automation.achala.BaseEngine;

import org.openqa.selenium.WebDriver;

public class FirefoxDriver {
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "H:\\Workspace\\Achala_Bank\\Drivers\\geckodriver.exe");
		WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();		
		 driver.get("https://www.gmail.com/");
	}

	

}
