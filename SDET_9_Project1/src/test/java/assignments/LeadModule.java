package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.ExcelUtility;
import com.crm.autodesk.generics.FileUtility;
import com.crm.autodesk.generics.JavaUtils;
import com.crm.autodesk.generics.WebDriverUtil;

@Listeners(extentreport.ItestListeners.class)
public class LeadModule {
@Test
/**
 * script to create lead
 * @throws Throwable
 */
public void createLeadTest() throws Throwable {
	
	String browser=System.getProperty("Browser");

	/*String url=System.getProperty("url");
	String un=System.getProperty("username");
	String pwd=System.getProperty("password");*/
	
	JavaUtils j=new JavaUtils();
	WebDriverUtil wb=new WebDriverUtil();
	ExcelUtility excel=new ExcelUtility();
	FileUtility fl=new FileUtility();
	
	String lastName=excel.getExcelData("Sheet1", 1, 1);
	String company=excel.getExcelData("Sheet1", 2, 1);
	String leadDropDown=excel.getExcelData("Sheet1", 4, 1);
	String industryDropDown=excel.getExcelData("Sheet1", 5, 1);
	//String phoneTextBox=excel.getExcelData("Sheet1", 6, 1);
	//int phoneTextBox=55555;
	String leadStatus=excel.getExcelData("Sheet1", 7, 1);
	String ratingDropDown=excel.getExcelData("Sheet1", 8, 1);
	
	/*launching browser using eclipse line*/
	WebDriver driver=null;
	if(browser.equalsIgnoreCase("chrome"))
	{
	 driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
	 driver=new FirefoxDriver();
	}
	else
	{
   System.out.println("enter valid browsername");
	}
	
	/*login to app*/
	//WebDriver driver=new ChromeDriver();
	driver.get(fl.getPropertyKeyValue("url"));
	driver.findElement(By.name("user_name")).sendKeys(fl.getPropertyKeyValue("username"));
	driver.findElement(By.name("user_password")).sendKeys(fl.getPropertyKeyValue("password"));
	driver.findElement(By.id("submitButton")).click();
	
	/*navigate to leads module*/
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	
	/*data entering in lastName textbox*/
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName+j.GenerateRandomInt());
	
	/*data entering in company textbox*/
	driver.findElement(By.xpath("//input[@name='company']")).sendKeys(company+j.GenerateRandomInt());
	
	/*leadSource dropDown*/
	WebElement leadSource = driver.findElement(By.name("leadsource"));
	leadSource.click();
	wb.select(leadSource, leadDropDown);
	
	/*industry dropdown*/
	WebElement industryDrop = driver.findElement(By.name("industry"));
	industryDrop.click();
	wb.select(industryDrop, industryDropDown);
	
	//driver.findElement(By.id("phone")).sendKeys(phoneTextBox);
	
	/*leadStatus dropdown*/
	WebElement leadDrop = driver.findElement(By.name("leadstatus"));
	leadDrop.click();
	wb.select(leadDrop, leadStatus);
	
	/*ratings dropdown*/
	WebElement rating = driver.findElement(By.name("rating"));
	rating.click();
	wb.select(rating, ratingDropDown);
	
	/*save the lead*/
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String actualInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	boolean expectedInfo=actualInfo.contains(lastName);
	Assert.assertTrue(expectedInfo);
}
}
