package com.actitime.testscripts;

import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.WebdriverCommonLib;
import com.actitime.objectrepository.EnterTimeTrack;
import com.actitime.objectrepository.UserList;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateUser extends BaseClass  {
@Test
public void testCreateUser() throws InterruptedException {
   WebdriverCommonLib wb=new WebdriverCommonLib();
   wb.waitForElementInGui(driver);
   
   EnterTimeTrack et= new EnterTimeTrack(driver);
   et.getUsers().click();
   
   UserList ul=new UserList(driver);
   ul.getAddUserbtn().click();
   Thread.sleep(1000);
  ul.getAccesToActitimebtn().click();

	}

}
