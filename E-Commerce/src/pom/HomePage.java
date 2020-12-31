package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibraries.WebActionUtils;

public class HomePage extends BasePage
{

	//Creating the WebElements 
		@FindBy(linkText="Sign out")
		private WebElement signOutLink;
		
		@FindBy(linkText="Women")
		private WebElement womenMenu;
		
		@FindBy(xpath="(//a[text()='Dresses'])[2]")
		private WebElement dressesMenu;
		
		@FindBy(xpath="(//a[text()='T-shirts'])[2]")
		private WebElement tShirtsMenu;
		
		
		final static String pageTitle = "My account - My Store";
		final static String pageUrl = "http://automationpractice.com/index.php?controller=my-account";
		
		public HomePage(WebDriver driver, WebActionUtils webActionUtils) {
			super(driver,webActionUtils,pageTitle, pageUrl);
		}
		
		/**
		 * User Should give the name of the menu items either dresses or women or t-shirts
		 * The given menu name will be clicked
		 * @param menuName 
		 * @return Next Page Object ie ProductsListPage Object
		 */
		public ProductsListPage clickOnMenu(String menuName) {
			menuName=menuName.toLowerCase();
			switch(menuName) {
				case "dresses":webActionUtils.elementClick(dressesMenu);
							   break;
				case "women":webActionUtils.elementClick(womenMenu);
				             break;
				case "t-shirts":webActionUtils.elementClick(tShirtsMenu);
	            				break;
				
			}
			
			return new ProductsListPage(driver, webActionUtils);
		}
		
		public void logout() {
			webActionUtils.elementClick(signOutLink);
		}
		
	}
