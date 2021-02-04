package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Quotes {
   
	WebDriver driver;
	public Quotes(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath="//img[@title='Create Quote...']")
	private WebElement quotesImg;
   
   @FindBy(name="search_text")
   private WebElement searchFor;
   
   @FindBy(id="bas_searchfield")
   private WebElement InLst;
   
   @FindBy(name="submit")
   private WebElement searchNow;

public WebElement getQuotesImg() {
	return quotesImg;
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
   
   
	

}
