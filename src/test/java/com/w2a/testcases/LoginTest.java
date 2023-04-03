package com.w2a.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.testBase.TestBase;

public class LoginTest extends TestBase{
	
	
	@Test
	public void bankManagerLoginTest() {
		
		baseUtil.setUp("browser");
		homePage = baseUtil.getUrl("testUrl");
		homePage.bankManagerLogin();
		
		Assert.assertEquals(homePage.getPageTitle(), "XYZ Bank");
		
	}
	
	
	@Test(dataProvider="custData")
	public void customerLoginTest(HashMap<String,String> data) {
		
		baseUtil.setUp("browser");
		homePage = baseUtil.getUrl("testUrl");
		homePage.customerLogin(data.get("customerName"));
		
		Assert.assertEquals(homePage.getPageTitle(), "XYZ Bank");
		
	}
	
	
	
}
