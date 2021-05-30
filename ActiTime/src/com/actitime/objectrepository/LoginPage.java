package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;

public class LoginPage {
@FindBy(id="username")
private WebElement untbx;
@FindBy(name="pwd")
private WebElement pwdtbx;
@FindBy(id="loginButton")
private WebElement lgbtn;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void setLogin(String un,String pwd)
{
	untbx.sendKeys(un);
	pwdtbx.sendKeys(pwd);
	lgbtn.click();
}
}
