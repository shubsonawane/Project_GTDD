package com.guru99.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.guru99.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	public static String testDataSheetPath = "C:\\Users\\91820\\eclipse-workspace\\Guru99DemoProject\\src\\com\\guru99\\testdata\\Guru99LoginData.xlsx";
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;

		try {
			file = new FileInputStream(testDataSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int row = 0; row < sheet.getLastRowNum(); row++) {
			for (int col = 0; col < sheet.getRow(0).getLastCellNum(); col++) {
				data[row][col] = sheet.getRow(row + 1).getCell(col).toString();
				System.out.println("Object data fetched : " + data[row][col]);
			}
		}
		return data;
	}

	public static void takeScreenshot(WebDriver driver, String fileName) {

		try {
			//TakesScreenshot ts = (TakesScreenshot) driver;
			//File source = ts.getScreenshotAs(OutputType.FILE);
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"C:\\Users\\91820\\eclipse-workspace\\Guru99DemoProject\\Screenshots\\" + fileName + ".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
