package com.crm.autodesk.objectrrepositorylib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class Products extends WebDriverUtiles{

	WebDriver driver;
	public Products(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement prodImg;

	@FindBy(name="search_text")
	private WebElement searchFor;

	@FindBy(id="bas_searchfield")
	private WebElement InLst;

	@FindBy(xpath="//input[@type='button']")
	private WebElement searchNow;

	@FindBy(className="lvtHeaderText")
	private WebElement succesfulMsg;

	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement editBTN;

	@FindBy(xpath="//img[@title='Import Products']")
	private WebElement prodLookup;
	
	@FindBy(linkText="Create Filter")
    private WebElement filterLink;
	
	@FindBy(xpath="//select[@id='viewname']")
	private WebElement filter;
	
	public WebElement getFilter() {
		return filter;
	}

	public WebElement getFilterLink() {
		return filterLink;
	}

	public WebElement getProdLookup() {
		return prodLookup;
	}

	public WebElement getEditBTN() {
		return editBTN;
	}

	public WebElement getProdImg() {
		return prodImg;
	}

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getInLst() {
		return InLst;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getSuccesfulMsg() {
		return succesfulMsg;
	}

	public void searchProd(String productName) {
		searchFor.sendKeys(productName);
		InLst.click();
		select(InLst, "Product Name");
		searchNow.click();
		driver.findElement(By.linkText(productName)).click();
		}	
	}

	

