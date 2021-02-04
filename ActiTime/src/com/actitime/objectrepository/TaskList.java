package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskList {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addNewBtn;

	@FindBy(xpath="//div[@class='item createNewCustomer']")
	private WebElement addNewCustomer;

	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement enterCustomerNameTb;

	@FindBy(xpath="(//textarea[@placeholder='Enter Customer Description'])")
	private WebElement enterCustomerDescriptionTb;

	@FindBy(xpath="//div[.='- Select Customer -']")
	private WebElement selectCustomerDropDown;
	
	@FindBy(xpath="//div[@class='itemRow cpItemRow ' and .='Big Bang Company']")
	private WebElement ourCompanyOption;

	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath="//div[@class='title' and @title='HDFC_002']")
	private WebElement customerText;

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getAddNewCustomer() {
		return addNewCustomer;
	}

    public WebElement getEnterCustomerNameTb() {
		return enterCustomerNameTb;
	}

    public WebElement getEnterCustomerDescriptionTb() {
		return enterCustomerDescriptionTb;
	}

    public WebElement getSelectCustomerDropDown() {
		return selectCustomerDropDown;
	}

     public WebElement getOurCompanyOption() {
		return ourCompanyOption;
	}


	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

   
	public WebElement getCustomerText() {
		return customerText;
	}

	
	
	public TaskList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
