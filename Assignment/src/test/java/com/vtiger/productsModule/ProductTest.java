package com.vtiger.productsModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.objectrrepositorylib.Creatingnewproduct;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Products;
import com.crm.autodesk.objectrrepositorylib.ProductsInfo;

public class ProductTest extends BaseClass{
	
	@Test(groups="smoke")
	public void createProductTest() throws Throwable {
		
		/*testScript data*/
		String prodName = eLib.getExcelData("Contact", "tc_24", "productName")+jLib.generateRandomNum();
		
		/*click on product link*/
		Home hp=new Home(driver);
		hp.getProductlnk().click();
		
		/*navigate to product*/
		Products prod=new Products(driver);
		prod.getProdImg().click();
		
		/*create product*/
		Creatingnewproduct cnp=new Creatingnewproduct(driver);
		cnp.getProdName().sendKeys(prodName);
		cnp.getSaveBtn().click();
		
		/*step 5 : verify */
		ProductsInfo prodinfo = new ProductsInfo(driver);
		String actVal = prodinfo.getSuccessFullMsg().getText();
		Assert.assertTrue(actVal.contains(prodName));
	}

	@Test(groups="regression")
	public void toEditPrice() throws Throwable {
		
		/*testScript data*/
		String prodName = eLib.getExcelData("Contact", "tc_24", "productName");
		double UnitPrice = eLib.getIntExcelData("Contact", "tc_24", "unitPrice") ;
		
		/*click on product link*/
		Home hp=new Home(driver);
		hp.getProductlnk().click();
		
		/*search for product*/
		Products prod=new Products(driver);
		prod.getFilter().click();
		wLib.select(prod.getFilter(), "All");
		prod.searchProd(prodName);
		
	    /*click on edit*/
		prod.getEditBTN().click();

		/*click on more currency*/
		Creatingnewproduct ep=new Creatingnewproduct(driver);
		ep.getMoreCuurency().click();
		ep.getPriceTb().clear();
		Thread.sleep(1000);
		wLib.alertCancel(driver);
		ep.getPriceTb().sendKeys(UnitPrice+"");
		
		/*click on reset*/
		ep.getCloseBtn().click();
	}
	
	@Test(groups="regression")
	public void toEditStock() throws Throwable {
		
		/*testScript data*/
		String prodName = eLib.getExcelData("Contact", "tc_25", "productName");
		String usageDrop = eLib.getExcelData("Contact", "tc_25", "usageDropDown"); 
		double StockQty = eLib.getIntExcelData("Contact", "tc_25", "qtyInStock");
		double Unit = eLib.getIntExcelData("Contact", "tc_25", "unit") ;
		double recorderLevel = eLib.getIntExcelData("Contact", "tc_25", "recorderLevel") ;
		double qtyDemand = eLib.getIntExcelData("Contact", "tc_25", "qtyDemand") ;
		
		/*click on product link*/
		Home hp=new Home(driver);
		hp.getProductlnk().click();

		/*search for product*/
		Products prod=new Products(driver);
		prod.searchProd(prodName);

		/*click on edit*/
		prod.getEditBTN().click();
		
		/*selecting Dozen in usage unit dropdown*/
		Creatingnewproduct ep=new Creatingnewproduct(driver);
		ep.getUsageUnit().click();
		wLib.select(ep.getUsageUnit(), usageDrop);
		
		/*entering data in qty in stock*/
		ep.getQtyInStock().clear();
		ep.getQtyInStock().sendKeys(StockQty+"");
		
		/*select group radiobtn*/
		ep.getHandlerRadioBtn().click();
		
		/*entering data in unit/qty*/
		ep.getUnitTb().clear();
		ep.getUnitTb().sendKeys(Unit+"");
		
		/*entering data in recorderlevel*/
		ep.getRecorderTb().clear();
		ep.getRecorderTb().sendKeys(recorderLevel+"");
		
		/*entering data in qty in demand*/
		ep.getQtyDemandTb().clear();
		ep.getQtyDemandTb().sendKeys(qtyDemand+"");
		
	}
	
	@Test
	public void toUploadImg() throws Throwable {
		
		/*testScript data*/
		String prodName = eLib.getExcelData("Contact", "tc_25", "productName");
		
		/*click on product link*/
		Home hp=new Home(driver);
		hp.getProductlnk().click();

		/*search for product*/
		Products prod=new Products(driver);
		prod.searchProd(prodName);

		/*click on edit*/
		prod.getEditBTN().click();
		
		/*click on choose file*/
		Creatingnewproduct ep=new Creatingnewproduct(driver);
		ep.uploadImg("./testData/IMG_20210120_140235.JPG");
	}
	
	@Test
	public void toEditDesc() throws Throwable {
		/*testScript data*/
		String prodName = eLib.getExcelData("Contact", "tc_25", "productName");
		String desc = eLib.getExcelData("Contact", 20, 2);
		
		/*click on product link*/
		Home hp=new Home(driver);
		hp.getProductlnk().click();

		/*search for product*/
		Products prod=new Products(driver);
		prod.searchProd(prodName);

		/*click on edit*/
		wLib.waitforElementToBeClickable(driver, prod.getEditBTN());
		prod.getEditBTN().click();
		
		/*edit description*/
		Creatingnewproduct ep= new Creatingnewproduct(driver);
		if(ep.getDescTb()==null) {
		ep.getDescTb().sendKeys(desc);}
		else {
			ep.getDescTb().clear();
			ep.getDescTb().sendKeys(desc);
		}
		/*click on save*/
	   ep.getSaveBtn().click();
	   
	   /*verify*/
	   ProductsInfo prodInfo=new ProductsInfo(driver);
	   String actualMsg = prodInfo.getSuccessFullMsg().getText();
	   Assert.assertTrue(actualMsg.contains(prodName));
	}
}
