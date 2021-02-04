package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewInvoice {

	WebDriver driver;
	public CreatingNewInvoice(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subTb;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
    private WebElement orgName;
	
	@FindBy(name="bill_street")
	private WebElement billingAdd;
	
	@FindBy(name="ship_street")
	private WebElement shippingAdd;
	
	@FindBy(id="searchIcon1")
	private WebElement productsLookup;
	
	@FindBy(id="qty1")
	private WebElement qnty;
	
	@FindBy(xpath="//select[@name='invoicestatus']")
	private WebElement status;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSubTb() {
		return subTb;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getBillingAdd() {
		return billingAdd;
	}

	public WebElement getShippingAdd() {
		return shippingAdd;
	}

	public WebElement getProductsLookup() {
		return productsLookup;
	}

	public WebElement getQnty() {
		return qnty;
	}

	public WebElement getStatus() {
		return status;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
