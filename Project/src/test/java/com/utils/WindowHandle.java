package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WindowHandle {
	
	Set TotalWindowsOpened;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")	+ "/src/main/java/com/amazon/qa/testdata/amazonTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	public Set WindowsAssignments(WebDriver driver) {
		
		
		
// It will return the parent window name as a String
String CurrentWindow=driver.getWindowHandle();
System.out.println("currentWindow name is "+CurrentWindow);




try {
	TotalWindowsOpened=(Set) driver.getWindowHandles();
	System.out.println("total windows   "+TotalWindowsOpened.size());
	
	//verfiying the windows are unique:
	
	Iterator<String > iterator =TotalWindowsOpened.iterator();
	
	while(iterator.hasNext()) {
		
		String NextWindow=iterator.next();
		
		//System.out.println("current window name  before switch  "+whe.driver.getTitle());

		
		if(!NextWindow.equals(CurrentWindow)) {
			
			
			
			driver.switchTo().window(NextWindow);
			System.out.println(" after swtich window name   "+driver.getCurrentUrl());
			System.out.println(" current window id   "+NextWindow);
		}
	}
	
	
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return TotalWindowsOpened;

}
}
