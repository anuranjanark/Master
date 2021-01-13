package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrack {
	
@FindBy(id="container_tasks")
private WebElement tasksTab;

@FindBy(id="logoutLink")
private WebElement logoutbtn;

@FindBy(id="container_users")
private WebElement Users;

public WebElement getLogoutbtn() {
	return logoutbtn;
}

public WebElement getUsers() {
	return Users;
}

public WebElement getTasksTab() {
	return tasksTab;
  }

public EnterTimeTrack(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
