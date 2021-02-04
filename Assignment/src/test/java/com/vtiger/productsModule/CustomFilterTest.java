package com.vtiger.productsModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.objectrrepositorylib.CustomView;
import com.crm.autodesk.objectrrepositorylib.CustomViewInfo;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Products;

public class CustomFilterTest extends BaseClass{

	@Test
	public void createCustomFilter() throws Throwable {
		
		/*testData*/
		String view = eLib.getExcelData("Contact", 23, 2);
		
		/*click on product link*/
		Home hp=new Home(driver);
		hp.getQuickDropDown().click();
		wLib.select(hp.getQuickDropDown(), "New Product");
		
		/*validate*/
		String actualText = hp.getQuickDropDownverifyMsg().getText();
		Assert.assertTrue(actualText.contains("Create Product"));
		
		/*cancel*/
		hp.getCancelBtn().click();
		
		/*click on product*/
		hp.getProductlnk().click();
		
		/*click on create filter link*/
		Products p=new Products(driver);
		wLib.waitforElementToBeClickable(driver, p.getFilterLink());
		p.getFilterLink().click();
		
		/*entering data in view name*/
		CustomView cv=new CustomView(driver);
		CustomViewInfo cvi=new CustomViewInfo(driver);
		
		/*verify*/
		/*String actualMsg=cvi.getSuccessFullMsg().getText();
	    Assert.assertTrue(actualMsg.contains("Custom View"));*/
	    
	    /*entering data*/
		cv.getViewTb().sendKeys(view);
		cv.getSetDefault().click();
		cv.getList().click();
		cv.getSetpublic().click();
		cv.getSaveBtn().click();
	}
}
