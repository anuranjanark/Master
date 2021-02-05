package com.practise;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.DatabaseUtils;
import com.crm.autodesk.generics.JavaUtils;

/**
 * 
 * @author divya
 *
 */

public class SendAmount2 {
	DatabaseUtils db=new DatabaseUtils();
	JavaUtils j=new JavaUtils();
	@Test
	/**
	 * generate eid randomly
	 * @throws SQLException
	 */
	public void sendAmount() throws SQLException {
		System.out.println("insert amount into database");
		int eid=j.GenerateRandomInt();
		int result = db.executeDBNonSelectQuery("insert into emp values("+eid+", 'roopa', 'spurge', '')");
		Assert.assertEquals(result, 1);	
		WebDriver driver=new ChromeDriver();
		driver.get("https://crmaccess.vtiger.com/");
		driver.close();
	}
}
