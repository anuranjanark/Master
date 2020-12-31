package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebActionUtils;

public class BasePage 
{
	WebDriver driver;
	WebActionUtils webActionUtils;
	String pageTitle;
	String pageUrl;
	/**
	 * Performs Initialization of The Page Elements and also initializes webdriver and WebActionUtil
	 * @param driver
	 * @param webActionUtil
	 * @param pageTitle
	 * @param pageUrl
	 */
	public BasePage(WebDriver driver, WebActionUtils webActionUtils, String pageTitle,
					String pageUrl) {
		this.driver=driver;
		this.webActionUtils=webActionUtils;
		this.pageTitle=pageTitle;
		this.pageUrl=pageUrl;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPageTitle() {
		return driver.getTitle().equals(pageTitle);
	}
	
	public boolean verifyPageUrl()
	{
		return driver.getCurrentUrl().equals(pageUrl);
	}
	
}
