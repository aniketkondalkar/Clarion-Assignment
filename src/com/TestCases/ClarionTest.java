package com.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Locators.AddPromisePage;
import com.Locators.LoginPage;
import com.Locators.PromisePage;
import com.Locators.SearchPromise;

public class ClarionTest 
{
	//webdriver initialization
	WebDriver driver;
	@BeforeMethod
	public void Init()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://182.74.238.221/clarion_promise_qa/index.php");
	}
	
	@Test (priority=2)
	public void VerifyLogin()
	{

		LoginPage lp=new LoginPage(driver);
		lp.typeUserName();
		lp.typePass();
        lp.ClickLogin();
		WebElement LogoutButton=driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/table/tbody/tr[1]/td/a[3]/b"));
		if(LogoutButton.isDisplayed())
		{
			System.out.println("Login Succesfull for user");
		}
		else
		{
			System.out.println("Login failed");
		}
		
	}
	
	
	@Test (priority=1)
	public void VerifyBlankCreds()
	{
		LoginPage lp=new LoginPage(driver);
		lp.ClickLogin();
		WebElement InvalidMsg=driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]/td/font"));
		String ExpectedText="Invalid Username/password";
		String ActualText=InvalidMsg.getText();
		if(ActualText.equalsIgnoreCase(ExpectedText))
		{
			System.out.println("Username/Password cannot be blank");
		}
	}
	 
	
	@Test (priority=3)
	public void AddPromise()
	{
		LoginPage lp=new LoginPage(driver);
		lp.typeUserName();
		lp.typePass();
		lp.ClickLogin();
		PromisePage pp=new PromisePage(driver);
		pp.LogNewPromise();
		AddPromisePage ap=new AddPromisePage(driver);
		ap.selectValue();
		ap.EnterPromise();
		ap.LogPromise();
	}
	
	
	@Test (priority=4)
	public void VerifyPromise()
	{
		LoginPage lp=new LoginPage(driver);
		lp.typeUserName();
		lp.typePass();
		lp.ClickLogin();
		PromisePage pp=new PromisePage(driver);
		pp.verifyPromise();
		SearchPromise sp=new SearchPromise(driver);
		sp.EnterDate();
		sp.ClickSearch();
		sp.searchResult();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Entry added successfully");
		
		sp.ClickLogout();
		System.out.println("Logout Successfull");
		
	}

	//close driver
	@AfterMethod
	public void Close()
	{
		driver.quit();
	}
	
	
	
}
