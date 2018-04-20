package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNumberTest extends BaseTest
{
	@Test
	public void testVerifyBuildNumber() throws InterruptedException
	{
	   String loginTitle = ExcelData.getData(file_path, "Login", 1, 2);
	   String user = ExcelData.getData(file_path, "Login", 1, 0);
	   String pass = ExcelData.getData(file_path, "Login", 1, 1);
	   String timeTrackTitle=ExcelData.getData(file_path, "EnterTimeTrack", 1, 0);
	   String abuildNO=ExcelData.getData(file_path, "buildNO", 1, 0);
	   
	   LoginPage lp=new LoginPage(driver);
	   EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
	   	   
	   //verify title
	   lp.verifyTheTitle(loginTitle);
	   
	   //Enter valid un
	   Reporter.log("user name is: "+user,true);
	   lp.enterUserName(user);
	   
	   //Enter valid pw
	   Reporter.log("password is: "+pass,true);
	   lp.enterPassword(pass);
	   
	   //click on login
	   lp.clickOnLogin();
	   
	   //verify enter time track page
	   lp.verifyTheTitle(timeTrackTitle);
	   
	   //click on help
	   ep.clickOnHelp();
	   
	   //ep.click On About
	   ep.clickOnAbout();
	   
	   Thread.sleep(2000);
	   
	   //verify build number
	   String ebuildNO=ep.handlePop();
	   Assert.assertEquals(abuildNO, ebuildNO);
	   Reporter.log("build num is matching: "+ebuildNO,true);
	   
	   //close popup
	   ep.closePopUp();
	   
	   //click on logout
	   ep.clickOnLogout();
	}
	
}
