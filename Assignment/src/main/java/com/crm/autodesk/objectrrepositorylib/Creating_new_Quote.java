package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class Creating_new_Quote extends WebDriverUtiles{
  
	WebDriver driver;
	public Creating_new_Quote(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement subjectTB;
	
	@FindBy(name="quotestage")
	private WebElement quoteStageLst;
	
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
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement sucessfulMsg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createQuote(String subName, String quoteLst, String orgNam,
			String billingStret, String ShipStreet, String pName, String qty) {
		
		subjectTB.sendKeys(subName);
		quoteStageLst.click();
		select(quoteStageLst, quoteLst);
		waitforElementToBeClickable(driver, orgName);
		orgName.click();
		
		swicthToWindow(driver, "Accounts&action");
        Organizations org=new Organizations(driver);
        org.getSearchEdt().sendKeys(orgNam);
        org.getSearchNow().click();
        driver.findElement(By.xpath("//a[text()='"+orgNam+"']")).click();
        alertCancel(driver);
        swicthToWindow(driver, "Quotes");
        
        billingAdd.sendKeys(billingStret);
        shippingAdd.sendKeys(ShipStreet);
        
		productsLookup.click();
		swicthToWindow(driver, "Products&action");
	//	Home hp=new Home(driver);
		//hp.getProductlnk().click();
		
		Products p=new Products(driver);
		p.getSearchFor().sendKeys(pName);
		p.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+pName+"']")).click();
		swicthToWindow(driver, "Quotes");
		qnty.sendKeys(qty);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSucessfulMsg() {
		return sucessfulMsg;
	}
}
