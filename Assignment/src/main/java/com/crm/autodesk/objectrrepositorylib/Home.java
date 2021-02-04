package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;
/**
 * 
 * @author Deepak , Nithish, divya
 *
 */


public class Home  extends WebDriverUtiles {
	WebDriver driver;
	public Home(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	
	@FindBy(linkText = "Contacts")
    private WebElement contactLnk;
	
	@FindBy(linkText = "Organizations")
    private WebElement orgLnk;
	
	@FindBy(linkText = "Leads")
    private WebElement leadsLnk;
	
	@FindBy(linkText = "Products")
    private WebElement productlnk;
	
	@FindBy(xpath="//a[.= 'More']")
	private WebElement more;
	
	@FindBy(xpath="//a[.='Quotes']")
	private WebElement quote;
	
	@FindBy(id="qccombo")
	private WebElement quickDropDown;
	
	@FindBy(className="mailSubHeader")
	private WebElement quickDropDownverifyMsg;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	
	@FindBy(linkText="Invoice")
	private WebElement invoice;
	
    public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getQuickDropDownverifyMsg() {
		return quickDropDownverifyMsg;
	}

	public WebElement getQuickDropDown() {
		return quickDropDown;
	}

	public WebElement getProductlnk() {
		return productlnk;
	}

	public WebElement getQuote() {
		return quote;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	public void quickLst(String Text) {
		select(quickDropDown, Text);
	}
	
	public void logout() {
		moveToExpectedElemnet(driver, adminstrationImg);
		signOutLnk.click();
	}
	
	
	
	
	}
