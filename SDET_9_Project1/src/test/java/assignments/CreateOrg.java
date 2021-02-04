package assignments;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generics.JavaUtils;
import com.crm.autodesk.generics.WebDriverUtil;

public class CreateOrg {
@Test
public void CreateQuote() {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebDriverUtil wb=new WebDriverUtil();
	JavaUtils j=new JavaUtils();
	
	String orgName="TY"+j.GenerateRandomInt();
	String contLastNAme="divya"+j.GenerateRandomInt();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	WebElement orgTab = driver.findElement(By.linkText("Organizations"));
	wb.waitforElementToBeClickable(driver, orgTab);
	orgTab.click();
	
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	WebElement industryDD = driver.findElement(By.name("industry"));
	wb.select(industryDD, "Banking");
	industryDD.click();
	
	WebElement typeDD = driver.findElement(By.name("accounttype"));
	wb.select(typeDD, "Partner");
	typeDD.click();
	
	WebElement ratingDD = driver.findElement(By.name("rating"));
	wb.select(ratingDD, "Active");
	ratingDD.click();
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	boolean actStatus = actOrgName.contains(orgName);
	// Assert.assertEquals(actStatus, true);
	Assert.assertTrue(actStatus);*/
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(contLastNAme);
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
    /*Set<String> set = driver.getWindowHandles();
    Iterator<String> it = set.iterator();
    String paretntID = it.next();
    String chilID = it.next();*/
    
    wb.swicthToWindow(driver, "Account&action");
	  
	  wb.waitforElementToBeClickable(driver,
	  driver.findElement(By.id("search_txt")));
	  driver.findElement(By.id("search_txt")).sendKeys(orgName);
	  driver.findElement(By.name("search")).click();
	  driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	 
	   /* SWicth Back to Parent Window */
	   wb.swicthToWindow(driver, "Contacts");
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	   /*String actConatName =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  boolean status = actConatName.contains(contLastNAme);
		  Assert.assertTrue(actStatus);*/
	
}
}
