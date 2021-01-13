package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.objectrepository.EnterTimeTrack;
import com.actitime.objectrepository.TaskList;



@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateCustomer extends BaseClass {
	@Test
	public  void testCreateCustomer() throws EncryptedDocumentException, IOException {
		FileLib fl=new FileLib();
		String customerName=fl.getExcelValue("Sheet2", 3, 1);
		String customerDescription=fl.getExcelValue("Sheet2", 3, 2);
		String ourCompany=fl.getExcelValue("Sheet2", 3, 2);
		EnterTimeTrack ett=new EnterTimeTrack(driver);
		ett.getTasksTab().click();
		
		TaskList tl=new TaskList(driver);
		tl.getAddNewBtn().click();
		tl.getAddNewCustomer().click();
		tl.getEnterCustomerNameTb().sendKeys(customerName);
		tl.getEnterCustomerDescriptionTb().sendKeys(customerDescription);
		tl.getSelectCustomerDropDown().click();
		tl.getOurCompanyOption().click();
		tl.getCreateCustomerBtn().click();
		String actual=tl.getCustomerText().getText();
		Assert.assertEquals(actual, customerName);
		

	}
}
