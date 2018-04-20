package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InValidLoginTest extends BaseTest 
{
    @Test
    public void testInValidLogin() throws InterruptedException
    {

    	String loginTitle=ExcelData.getData(file_path, "Login", 1, 2);
    	int loginRC = ExcelData.getRowCount(file_path, "Login");
    	String eErrorMessage = ExcelData.getData(file_path, "Login", 1, 4);
    	LoginPage lp=new LoginPage(driver);
    	
	   //verify login page
 	   lp.verifyTheTitle(loginTitle);
 	   Reporter.log("......................................", true);
 	   
 	   for(int i=2;i<=loginRC;i++)
 	   {
 		   String user=ExcelData.getData(file_path, "Login", i, 0);
 		   String pass=ExcelData.getData(file_path, "Login", i, 1);

 		   //enter invalid un
 		   Reporter.log("user name is:", true);
 		   lp.enterUserName(user);
 		   
 		   //enter invalid pw
 		   Reporter.log("password is:", true);
 		   lp.enterPassword(pass);
 		   
 		   //click on login
 		   lp.clickOnLogin();
 		   
 		   Thread.sleep(2000);
 		   
 		   //verify error message
 		   String aErrorMessage=lp.verifErrorMessage();
 		   Assert.assertEquals(aErrorMessage, eErrorMessage);
 		   Reporter.log("Message is matching: "+eErrorMessage, true);
 		   Reporter.log("........................................", true);
 	   }
 	   
    	
    }
}
