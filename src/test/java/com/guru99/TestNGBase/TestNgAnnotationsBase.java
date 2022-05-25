package com.guru99.TestNGBase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.BeforeMethod;

import com.guru99.BankProject.PageClasses.LoginPage;
import com.guru99.BankProject.PageClasses.ManagerHomePage;
import com.guru99.EcommerceProject.PageClasses.EcommHomePage;
import com.guru99.base.BaseClass;

public class TestNgAnnotationsBase implements ITestListener{
	
	WebDriver driver = BaseClass.getDriver();
	
	//Bank:
	public LoginPage loginPage;
	public ManagerHomePage managerHomePage;
	
	//Ecomm:
	public String SheetName = "loginData1";
	public EcommHomePage ecommHomePage;

	@BeforeMethod
	public void setUp() {

		BaseClass.initialization();
		loginPage = new LoginPage();
		ecommHomePage = new EcommHomePage();
	}
}
