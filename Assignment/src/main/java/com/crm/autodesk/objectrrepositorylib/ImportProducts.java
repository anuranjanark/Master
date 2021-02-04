package com.crm.autodesk.objectrrepositorylib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportProducts {
	WebDriver driver;
	public ImportProducts(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="import_file")
	private WebElement chooseFile;
	
	@FindBy(id="auto_merge")
	private WebElement checkBox;
	
	@FindBy(className="crmButton big edit")
	private WebElement nextBtn;
	
	@FindBy(className="crmButton small")
	private WebElement arrow;
	
	@FindBy(id="available_fields ")
	private List<WebElement> duplicate;
	
	public WebElement getArrow() {
		return arrow;
	}

	public List<WebElement> getDuplicate() {
		return duplicate;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}
}
