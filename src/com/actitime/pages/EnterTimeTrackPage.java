package com.actitime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;
import com.actitime.generic.GenericUtils;

public class EnterTimeTrackPage extends BasePage
{
   
	//Declaration
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
	private WebElement helpBTN;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement selAboutActiTIME;
	
	@FindBy(xpath="//span[contains(.='build']")
	private WebElement buildNO;
	
	@FindBy(xpath="//div[@id='aboutPopupCloseButtonId']")
	private WebElement closePopUp;
	
	
	
	//Implimentation
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickOnLogout()
	{
		logoutBTN.click();
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public void clickOnHelp()
	{
		helpBTN.click();
		
	}
	public void clickOnAbout()
	{
		selAboutActiTIME.click();
	}
	
	public String handlePop()
	{
		String ebuildNO=GenericUtils.handleHiddenDivisionPopup(driver);
		return ebuildNO;
	}
	public void closePopUp()
	{
		closePopUp.click();
	}
}
