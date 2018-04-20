package com.actitime.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
   public static void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
   {
	   Actions act=new Actions(driver);
	   act.dragAndDrop(source, target);
			   
   }
   public static void doubleClick(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.doubleClick();
	   
   }
   public static void contextClick(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.contextClick();
   }
   public static void compositeClick(WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   act.perform();
	   
   }
   public static void dropDownList(WebDriver driver,WebElement target)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(target);
   }
   public static void selectByIndex(WebElement element,int index)
   {
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
   public static void selectByValue(WebElement element,String value)
   {
	   Select sel=new Select(element);
	   sel.selectByValue(value);
   }
   public static void selectByVisibleText(WebElement element,String name)
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(name);
   }
   public static void deselectByIndex(WebElement element,int index)
   {
	   Select sel=new Select(element);
	   sel.deselectByIndex(index);
   }
   public static void deselectByValue(WebElement element,String value)
   {
	   Select sel=new Select(element);
	   sel.deselectByValue(value);
   }
   public static void deselectByVisibleText(WebElement element,String name)
   {
	   Select sel=new Select(element);
	   sel.deselectByVisibleText(name);
   }
   public static void deselectAll(WebElement element)
   {
	   Select sel=new Select(element);
	   sel.deselectAll();
   }
   public static List<WebElement> getAllSelectedOptions(WebElement element)
   {
	   Select sel=new Select(element);
	   List<WebElement> allSelOpt = sel.getAllSelectedOptions();
	   return allSelOpt;
   }
   /**
    * @author brindha
    * 
    * @param element
    * @return 
    */
   public static WebElement getFirstSelectedOption(WebElement element)
   {
	   Select sel=new Select(element);
	   WebElement firstOpt = sel.getFirstSelectedOption();
	   return firstOpt;
   }
   public static List<WebElement> getOptions(WebElement element)
   {
	   Select sel=new Select(element);
	   List<WebElement> allOptions = sel.getOptions();
	   return allOptions;
   }
   public static void javaScriptAlertPop(WebDriver driver)
   {
	   Alert a = driver.switchTo().alert();
	   a.accept();
   }
   public static void javaScriptConfirmationPop(WebDriver driver)
   {
	   Alert a = driver.switchTo().alert();
	   a.dismiss();
   }
   public static void getScreenShot(WebDriver driver,String name)
   {
		
		try {
			   TakesScreenshot t=(TakesScreenshot)driver;
			   File src = t.getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(src, new File("./screenshots/"+name+".png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   public static String handleHiddenDivisionPopup(WebDriver driver) 
   {
	      WebElement buildNo=driver.findElement(By.xpath("//span[contains(text(),'41383')]"));
	      String ebuildNO = buildNo.getText();
	      return ebuildNO;
    
   }
}