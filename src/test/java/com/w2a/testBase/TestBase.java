package com.w2a.testBase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.w2a.basePage.BaseUtility;
import com.w2a.pages.AddCustomer;
import com.w2a.pages.Customers;
import com.w2a.pages.HomePage;
import com.w2a.pages.OpenAccount;
import com.w2a.utilities.ExcelReader;

public class TestBase {
	
	public static BaseUtility baseUtil = new BaseUtility();
	public static HomePage homePage;
	public static AddCustomer addCust;
	public static OpenAccount openAcc;
	public static Customers customer;
	public static ExcelReader excelReader;
	
	
	@DataProvider
	public Object[][] custData(Method m){
		
		excelReader = new ExcelReader(System.getProperty("user.dir")+"\\Resources\\excel\\XYZ Bank.xlsx");
		String sheetName = m.getName();
		return excelReader.getData(sheetName);
		
	}
	
	@AfterSuite
	public void closeAll() {
		
		baseUtil.tearDown();
	}
	

}
