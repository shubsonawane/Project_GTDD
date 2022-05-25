package com.guru99.EcommerceProject.PageClasses;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.guru99.base.BaseClass;

public class EcommHomePage extends BaseClass{

	public int scc = 0;
	public static String filepath = "\\src\\com\\guru99\\configRepositories\\EcommConfig.properties";

	private StringBuffer verificationErrors = new StringBuffer();
	
	public EcommHomePage() {
		super(filepath);
	}

	public void TC1_verifyPageTitle() throws Exception {

		//driver.get("http://live.techpanda.org/index.php/");
		
		String demoSite = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(demoSite);
		try {
			Assert.assertEquals("THIS IS DEMO SITE FOR   ", demoSite);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
	}

	public void TC2_clickMobileTab() {
	
		driver.findElement(By.linkText("MOBILE")).click();
		
	}
	
	public void TC3_sortProductsByName() {
		// Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
		new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

		// Step 6. Verify all products are sorted by name
		// this will take a screen shot of the manager's page after a successful login
		scc = (scc + 1);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
		FileUtils.copyFile(scrFile, new File(png));
	}

}
