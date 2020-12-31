package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibraries.WebActionUtils;

public class LoginPage extends BasePage
{
	
	@FindBy(linkText="Sign in")
	private WebElement signInLink;
	
	@FindBy(id="email")
	private WebElement emailTB;
	
	@FindBy(id="passwd")
	private WebElement passwordTB;
	
	@FindBy(id="SubmitLogin")
	private WebElement loginBTN;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPasswordLink;
	
	final static String pageTitle = "Log - My Store";
	final static String pageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
	public LoginPage(WebDriver driver, WebActionUtils webActionUtils) {
		super(driver,webActionUtils,pageTitle, pageUrl);
	}
	
	/**
	 * @param username String value to be entered into email TextBox
	 * @param password String value to be entered into password TextBox
	 * @return The Next Page Object (Landing Page)
	 */
	public HomePage login(String username,String password) {
		webActionUtils.elementClick(signInLink);
		webActionUtils.enterData(emailTB, username);
		webActionUtils.enterData(passwordTB, password);
		webActionUtils.elementClick(loginBTN);
		return new HomePage(driver, webActionUtils);
	}
}
