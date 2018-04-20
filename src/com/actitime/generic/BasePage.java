package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
   //Declaration
	public WebDriver driver;
	
	//initialization
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//utilization
	public void verifyTitle(String etitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
		     wait.until(ExpectedConditions.titleIs(etitle));
		     Reporter.log("Title is matching: "+etitle ,true);
		}
		catch(Exception e)
		{
		    Reporter.log("Title is not matching:", true);
		    Reporter.log("Actual title is:"+driver.getTitle()+"Expected title is: "+etitle, true);
                
		}
	}
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
		     wait.until(ExpectedConditions.visibilityOf(element));
		     Reporter.log("Title is present: "+element,true);
		}
		catch(Exception e)
		{
		    Reporter.log("Title is not present:", true);
		    		    
		}
		
	}
	public void verifyBuildNumber(String buildNO)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
		     wait.until(ExpectedConditions.alertIsPresent());
		     Reporter.log("Build number is: "+buildNO,true);
		}
		catch(Exception e)
		{
		    Reporter.log("Build Number is not present:", true);
		    		    
		}
	}
}
