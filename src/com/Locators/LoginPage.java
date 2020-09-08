package com.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
  WebDriver driver;
  
  By username=By.name("txtUsername");
  By password=By.name("txtPassword");
  By LoginButton=By.xpath("//input[@value='Login']");
  //By Logout=By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/table/tbody/tr[1]/td/a[3]/b");
  
  public LoginPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  public void typeUserName()
  {
	  driver.findElement(username).sendKeys("sanjeetk@clariontechnologies.co.in");;
  }
  
  public void typePass()
  {
	  driver.findElement(password).sendKeys("clarion");;
  }
  
  public void ClickLogin()
  {
	  driver.findElement(LoginButton).click();
  }
 
 
  
  
  
  
  
}
