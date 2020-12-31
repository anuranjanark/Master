package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.GenericXLLibrary;
import genericlibraries.Utility;
import pom.HomePage;
import pom.OrderDetailPage;
import pom.ProductDetailsPage;
import pom.ProductsListPage;


//Taking Data From ExcelSheet and Verifying whether
//the added product is displayed in the ODP Page
public class TC001 extends BaseTest 
{
	@Test(description="Test case to verify if the added product is displayed in ODP page")
	public void testAddingProductToKart() {
		HomePage hp = new HomePage(driver,webActionUtils);
		
		//Getting testdata from XL
		String sheetName = "TC001";
		String menuName = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 0);
		String productId = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 1);
		productId = Utility.split(productId);
		String increaseQuantity = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 2);
		int inQ=Integer.parseInt(Utility.split(increaseQuantity));
		String decreaseQuantity = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 3);
		int deQ=Integer.parseInt(Utility.split(decreaseQuantity));
		String size = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 4);
		String color = GenericXLLibrary.getData(XL_PATH, sheetName, 1, 5);
		
		ProductsListPage productListPage = hp.clickOnMenu(menuName);
		ProductDetailsPage pdp = productListPage.selectProduct(productId);
		OrderDetailPage odp = pdp.addSelectedItemToKart(inQ, deQ, size, color);
		Assert.assertEquals(odp.isProductDisplayed(productId), true);
	}
}