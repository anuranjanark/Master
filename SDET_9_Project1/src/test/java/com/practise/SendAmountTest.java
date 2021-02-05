package com.practise;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.DatabaseUtils;

public class SendAmountTest {
	DatabaseUtils db=new DatabaseUtils();
	@Test
	/**
	 * hardcoding the eid
	 * @throws SQLException
	 */
	public void sendAmount() throws SQLException {
		System.out.println("insert amount into database");
		int result = db.executeDBNonSelectQuery("insert into emp values(7, 'roopa', 'spurge', '')");
		Assert.assertEquals(result, 1);	
		WebDriver driver=new ChromeDriver();
		driver.get("https://crmaccess.vtiger.com/");
		driver.close();
	}

}
