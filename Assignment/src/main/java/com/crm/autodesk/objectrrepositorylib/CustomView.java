package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomView {

	WebDriver driver;
	public CustomView(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='viewName']")
	private WebElement ViewTb;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='setDefault']")
	private WebElement setDefault;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='setMetrics']")
	private WebElement list;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='setStatus']")
	private WebElement setpublic;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getViewTb() {
		return ViewTb;
	}

	public WebElement getSetDefault() {
		return setDefault;
	}

	public WebElement getList() {
		return list;
	}

	public WebElement getSetpublic() {
		return setpublic;
	}
}
