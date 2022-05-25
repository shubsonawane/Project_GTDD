package com.guru99.BankProject.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.base.BaseClass;

public class LoginPage extends BaseClass {

	// object repository/Page factory : @FindBy annotation is used for PageFactory

	@FindBy(name = "uid") // if we are using xpath then we have to write xpath instead of the name
							// attribute on this line
	static WebElement username;

	@FindBy(name = "password")
	static WebElement passwd;

	@FindBy(name = "btnLogin")
	static WebElement LoginButton;

	public static String filepath = "\\src\\com\\guru99\\configRepositories\\config.properties";
	
	// Initializing the PageObjects :
	public LoginPage() {
		super(filepath);
		PageFactory.initElements(driver, this);
	}

	// Login page methods/Actions :

	public static String validatePageTitle() {
		return driver.getTitle();

	}

	public static void validateImage() {

	}

	public static ManagerHomePage login() {

		username.sendKeys(prop.getProperty("username"));
		passwd.sendKeys(prop.getProperty("password"));
		LoginButton.click();

		return new ManagerHomePage(); // bcoz Homepage would be the landing page after Login.
	}
}
