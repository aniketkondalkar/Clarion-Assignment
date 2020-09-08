package com.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddPromisePage 
{

	WebDriver driver;
	
	By SelectPromise=By.name("cboEmp");
	By EnterPromise=By.id("txtPromise");
	By SubmitPromise=By.id("btnSubmit");
	
	public AddPromisePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectValue()
	{
		WebElement DD=driver.findElement(SelectPromise);
		Select value=new Select(DD);
		value.selectByVisibleText("Sonali test");
		
	}
	public void EnterPromise()
	{
		driver.findElement(EnterPromise).sendKeys("New Promise Assignment");
	}
	 
	public void LogPromise()
	{
		driver.findElement(SubmitPromise).click();
	}
	
	
}
