package com.guru99.pages.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.base.BaseClass;
import com.guru99.pages.HomePage.ManagerHomePage;

public class LoginPage extends BaseClass {

	// object repository/Page factory : @FindBy annotation is used for PageFactory

	@FindBy(name = "uid") // if we are using xpath then we have to write xpath instead of the name
							// attribute on this line
	static WebElement username;

	@FindBy(name = "password")
	static WebElement passwd;

	@FindBy(name = "btnLogin")
	static WebElement LoginButton;

	// Initializing the PageObjects :
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Login page methods/Actions :

	public static String validatePageTitle() {
		return driver.getTitle();

	}

	public static void validateImage() {

	}

	public static ManagerHomePage login(String uname, String pwd) {

		username.sendKeys(uname);
		passwd.sendKeys(pwd);
		LoginButton.click();

		return new ManagerHomePage(); // bcoz Homepage would be the landing page after Login.
	}
}
