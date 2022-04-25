package com.guru99.tests.loginTest;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.base.BaseClass;
import com.guru99.pages.HomePage.ManagerHomePage;
import com.guru99.pages.loginPage.LoginPage;
import com.guru99.util.TestUtil;

public class LoginTest extends BaseClass{
	
	LoginPage loginPage;
	ManagerHomePage managerHomePage;
	String SheetName = "loginData1";
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void seUp() {
		
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	
	
	// fetching data from config.properties file :
	
	@Test(priority = 2)
	public void loginTest() {
		managerHomePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
	@DataProvider
	public Object[][] getLoginTestData(){
		Object[][] data = TestUtil.getTestData(SheetName);
		return data;
	}
	
	
	//fetching data using dataprovider from the excel file, using @DataProvider and apache poi :

	@Test(enabled = false, priority = 2, dataProvider = "getLoginTestData")
	public void loginTest(String username, String password) {
		//managerHomePage = loginPage.login(username, password);
		loginPage.login(username, password);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtil.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
