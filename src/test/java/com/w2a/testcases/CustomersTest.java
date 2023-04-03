package com.w2a.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.testBase.TestBase;

public class CustomersTest extends TestBase{
	
	@Test(dataProvider="custData")
	public void customerTest(HashMap<String,String> data) {
		
		baseUtil.setUp("browser");
		homePage = baseUtil.getUrl("testUrl");
		addCust = homePage.bankManagerLogin();
		customer = addCust.clickCustomers();
		boolean result = customer.searchCustByName(data.get("customer"));
		Assert.assertTrue(result);
	}
	
	@Test(dataProvider="custData")
	public void deleteCustomerTest(HashMap<String,String> data) {
		
		baseUtil.setUp("browser");
		homePage = baseUtil.getUrl("testUrl");
		addCust = homePage.bankManagerLogin();
		customer = addCust.clickCustomers();
		boolean result = customer.deleteCust(data.get("customerName"));
		Assert.assertTrue(result);
		
	}
	
	

}
