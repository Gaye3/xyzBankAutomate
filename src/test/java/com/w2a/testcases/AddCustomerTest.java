package com.w2a.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.testBase.TestBase;

public class AddCustomerTest extends TestBase{
	
	
	@Test(dataProvider="custData")
	public void addCustomerTest(HashMap<String,String> data) {
		
		baseUtil.setUp("browser");
		homePage = baseUtil.getUrl("testUrl");
		addCust = homePage.bankManagerLogin();
		addCust.clickAddCustomer();
		addCust.typeFirstName(data.get("firstname"));
		addCust.typeLastName(data.get("lastname"));
		addCust.typePostCode(data.get("postcode"));
		addCust.clickSubmit();
		
		Assert.assertTrue(addCust.isAlertDisplayed());
		
	}
	

}
