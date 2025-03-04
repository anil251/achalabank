package com.selenium.automation.achala.Supporters;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.automation.achala.BaseEngine.BaseTest;

public class Extent_Reports extends BaseTest {
	
	public void Loginfo(String info) {
		if (info=="INFO") {
			getExtentTest().log(LogStatus.INFO, info);
			
		}
		else if (info=="PASS") {
			getExtentTest().log(LogStatus.PASS, info);
			
		}
		else if (info=="FAIL") {
			getExtentTest().log(LogStatus.FAIL, info);
		}
		else if (info=="SKIP") {
			getExtentTest().log(LogStatus.SKIP, info);
		}
		else if (info=="ERROR") {
			getExtentTest().log(LogStatus.ERROR, info);
		}
		
	}
	public void Loginnfo(String info, String detailinfo) {
		if (info=="INFO") {
			getExtentTest().log(LogStatus.INFO, info,detailinfo);
			
		}
		else if (info=="FAIL") {
			getExtentTest().log(LogStatus.FAIL,info, detailinfo);
		}

	
	else if (info=="SKIP") {
		getExtentTest().log(LogStatus.SKIP,info, detailinfo);
	}
	else if (info=="ERROR") {
		getExtentTest().log(LogStatus.ERROR,info, detailinfo);
	}

  }
}
