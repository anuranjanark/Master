package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserList {

	@FindBy(xpath="//div[.='New User']")
	private WebElement addUserbtn;
	
	//@FindBy(xpath="//div[@class='components_switcher small animated on']")
	@FindBy(xpath="//div[@id='createUserPanel_accessToOtherProductSelectorPlaceholder']")
	private WebElement AccesToActitimebtn;

	public WebElement getAddUserbtn() {
		return addUserbtn;
	}

	public WebElement getAccesToActitimebtn() {
		return AccesToActitimebtn;
	}
	public UserList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
