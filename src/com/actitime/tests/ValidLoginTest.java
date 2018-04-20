package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginTest extends BaseTest
{
   @Test
   public void testValidLoginLogout()
   {
	   String loginTitle = ExcelData.getData(file_path, "Login", 1, 2);
	   String user = ExcelData.getData(file_path, "Login", 1, 0);
	   String pass = ExcelData.getData(file_path, "Login", 1, 1);
	   String timeTrackTitle=ExcelData.getData(file_path, "EnterTimeTrack", 1, 0);
	   
	   LoginPage lp=new LoginPage(driver);
	   EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
	   	   
	   //verify login page
	   lp.verifyTheTitle(loginTitle);
	   
	   //Enter valid un
	   Reporter.log("user name is: "+user,true);
	   lp.enterUserName(user);
	   
	   //Enter valid pw
	   Reporter.log("password is: "+pass,true);
	   lp.enterUserName(pass);
	   
	   //click on login
	   lp.clickOnLogin();
	   
	   //verify enter time track page
	   lp.verifyTheTitle(timeTrackTitle);
	   
	   //click on logout
	   ep.clickOnLogout();
	   
	   //verify login page
	   lp.verifyTheTitle(loginTitle);
   }
}
