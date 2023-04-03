package com.w2a.pages;

import com.w2a.basePage.BaseUtility;

public class HomePage extends BaseUtility{
	
	
	public AddCustomer bankManagerLogin() {
		
		click("bankManagerLoginBtn_xpath");
		return new AddCustomer();
	}
	
	
	public void customerLogin(String name) {
		
		click("customerLoginBtn_xpath");
		click("yourName_id");
		select("yourName_id",name);
		click("login_xpath");
		
	}
	
	

}
