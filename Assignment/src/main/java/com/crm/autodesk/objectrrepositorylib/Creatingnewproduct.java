package com.crm.autodesk.objectrrepositorylib;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creatingnewproduct {

	WebDriver driver;
	public Creatingnewproduct(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(name="productname")
private WebElement prodName;

@FindBy(linkText="more currencies »")
private WebElement moreCuurency;

@FindBy(id="curname1")
private WebElement priceTb;

@FindBy(id="cur_reset1")
private WebElement resetBtn;

@FindBy(xpath="//th/img[@src='themes/images/close.gif']")
private WebElement closeBtn;

@FindBy(name="usageunit")
private WebElement usageUnit;

@FindBy(id="qtyinstock")
private WebElement qtyInStock;

@FindBy(name="assigntype")
private WebElement handlerRadioBtn;

@FindBy(id="qty_per_unit")
private WebElement unitTb;

@FindBy(id="reorderlevel")
private WebElement recorderTb;

@FindBy(id="qtyindemand")
private WebElement qtyDemandTb;

@FindBy(id="my_file_element")
private WebElement productImg;

@FindBy(name="description")
private WebElement descTb;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public WebElement getProdName() {
	return prodName;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getDescTb() {
	return descTb;
}

public WebElement getMoreCuurency() {
	return moreCuurency;
}

public WebElement getPriceTb() {
	return priceTb;
}

public WebElement getResetBtn() {
	return resetBtn;
}

public WebElement getCloseBtn() {
	return closeBtn;
}

public WebElement getUsageUnit() {
	return usageUnit;
}

public WebElement getQtyInStock() {
	return qtyInStock;
}

public WebElement getHandlerRadioBtn() {
	return handlerRadioBtn;
}

public WebElement getUnitTb() {
	return unitTb;
}

public WebElement getRecorderTb() {
	return recorderTb;
}

public WebElement getQtyDemandTb() {
	return qtyDemandTb;
}

public WebElement getProductImg() {
	return productImg;
}

public void uploadImg(String path) {
	File f=new File(path);
	String absolutePath=f.getAbsolutePath();
	getProductImg().sendKeys(absolutePath);
}
}
