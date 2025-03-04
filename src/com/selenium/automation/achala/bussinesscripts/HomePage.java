package com.selenium.automation.achala.bussinesscripts;

import org.testng.annotations.Test;

import com.selenium.automation.achala.BaseEngine.BaseTest;

public class HomePage extends BaseTest {
	
	@Test
	public void openbrowser() {
		getDriver().get("http://get2loan.com/");
	}

}


