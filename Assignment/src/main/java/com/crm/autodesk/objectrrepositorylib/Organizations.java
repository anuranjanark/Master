package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class Organizations extends WebDriverUtiles {

	WebDriver driver;
	public Organizations(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgImg;


	@FindBy(name="search_field")
	private WebElement inDropDown;

	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="search")
	private WebElement searchNow;


	public WebElement getInDropDown() {
		return inDropDown;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

/*public void searcOrg(String orgName) {
	searchEdt.sendKeys(orgName);
	inDropDown.click();
	swicthToWindow(driver, ");
	searchNow.click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
}*/

}
