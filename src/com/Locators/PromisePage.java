package com.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PromisePage 
{
   WebDriver driver;
   
   By LogPromise=By.linkText("Log Promise");
   By SearchPromises=By.linkText("Promises To");
   
   public PromisePage(WebDriver driver)
   {
	   this.driver=driver;
   }
   
   public void LogNewPromise()
   {
	   driver.findElement(LogPromise).click();
   }
	
	public void verifyPromise()
	{
		driver.findElement(SearchPromises).click();
	}
}
