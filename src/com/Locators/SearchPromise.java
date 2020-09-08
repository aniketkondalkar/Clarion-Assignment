package com.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPromise 
{

	WebDriver driver;
	By SearchByDate=By.id("txtStartDate");
	By SearchButton=By.name("btnSearch");
	By SearchRes=By.xpath("//*[contains(text(),'New Promise Assignment')]");
	By Logout=By.linkText("LOGOUT");
	
	public SearchPromise(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void EnterDate()
	{
		driver.findElement(SearchByDate).sendKeys("07-09-2020");
	}
	
	public void ClickSearch()
	{
		driver.findElement(SearchButton).click();
	}
	
	public void searchResult()
	{
		driver.findElement(SearchRes).isDisplayed();
	}
	public void ClickLogout()
	{
		driver.findElement(Logout).click();
	}
}
