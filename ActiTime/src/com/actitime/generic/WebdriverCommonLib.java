package com.actitime.generic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverCommonLib {
public void webDriverWait(WebDriver driver, WebElement element)
{
	WebDriverWait wait =new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(element));//
}
public void waitForElementInGui(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void customWait(WebElement element)
{
	int i=0;
	while(i<100)
	{
		try
		{
			element.isDisplayed();
			break;
		}
		catch(NoSuchElementException e)
		{
			i++;
		}
	}
}
public void selectClause(WebElement element, int i) 
{
	Select select=new Select(element);
	select.selectByIndex(i);
}
public void selectClause(WebElement element, String text) 
{
	Select select=new Select(element);
	select.selectByVisibleText(text);
}
public void jsClick(WebDriver driver, WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("argument[0].click();", element);
		
}
}
