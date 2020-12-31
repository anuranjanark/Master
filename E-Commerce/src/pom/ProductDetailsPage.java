package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibraries.WebActionUtils;

public class ProductDetailsPage extends BasePage
{
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(className="icon-minus")
	private WebElement minusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']/li/a")
	private List<WebElement> colorPickerList;
	
	@FindBy(name="Submit")
	private WebElement addToKartBTN;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOutBTN;

	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueShoppingBTN;
	
	@FindBy(className="cross")
	private WebElement closeIcon;
	
	final static String pageTitle = "Printed Summer Dress - My Store";
	final static String pageUrl = "http://automationpractice.com/index.php?id_product=5&controller=product";
	
	public ProductDetailsPage(WebDriver driver, WebActionUtils webActionUtils) {
		super(driver,webActionUtils,pageTitle, pageUrl);
	}
	
	public void increaseQuantity(int numToIncrease) {
		for(int i=1;i<=numToIncrease;i++) {
			webActionUtils.elementClick(plusIcon);
		}
	}
	
	public void decreaseQuantity(int numToDecrease) {
		for(int i=1;i<=numToDecrease;i++) {
			webActionUtils.elementClick(minusIcon);
		}
	}
	
	public void selectSize(String text) {
		webActionUtils.selectByText(sizeListBox, text);
	}
	
	public void selectColor(String colorName) {
		for(WebElement colorElement:colorPickerList) {
			if(colorElement.getAttribute("name").equals(colorName)) {
				webActionUtils.elementClick(colorElement);
				break;
			}
		}
	}
	
	public void clickOnAddToKart() {
		webActionUtils.elementClick(addToKartBTN);
	}
	
	public OrderDetailPage clickOnProceedToChekout() {
		webActionUtils.elementClick(proceedToCheckOutBTN);
		return new OrderDetailPage(driver,webActionUtils);
	}
	
	public void clickOnContinueShopping() {
		webActionUtils.elementClick(continueShoppingBTN);
	}
	
	public void clickOnCloseIcon() {
		webActionUtils.elementClick(closeIcon);
	}
	
	public OrderDetailPage addSelectedItemToKart(int numToIncrease, int numToDecrease,
								String text, String colorName) {
		increaseQuantity(numToIncrease);
		decreaseQuantity(numToDecrease);
		selectSize(text);
		selectColor(colorName);
		clickOnAddToKart();
		return clickOnProceedToChekout();
	}
}
