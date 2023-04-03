package com.w2a.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.testBase.TestBase;

public class OpenAccountTest extends TestBase{
	
	
	@Test(dataProvider="custData")
	public void openAccountTest(HashMap<String,String> data) {
		
		baseUtil.setUp("browser");
		homePage = baseUtil.getUrl("testUrl");
		addCust = homePage.bankManagerLogin();
		openAcc = addCust.clickOpenAcc();
		openAcc.selectCustomerName(data.get("customerName"));
		openAcc.selectCurrency(data.get("currency"));
		openAcc.clickProcess();
		
		Assert.assertTrue(openAcc.isAlertDisplay());
		
	}

}
