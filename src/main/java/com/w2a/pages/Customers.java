package com.w2a.pages;

import java.util.ArrayList;

import com.w2a.basePage.BaseUtility;

public class Customers extends BaseUtility{
	
	
	public boolean searchCustByName(String name) {
		
		type("searchBox_xpath",name);
		return locateElement("rowOne_xpath").isDisplayed();
		
	}
	
	public ArrayList<String> getCustDetails(String name) {
		
		if(searchCustByName(name)) {
			
			ArrayList<String> list = new ArrayList<String>();
			
			for(int i=1;i<5;i++) {
				String temp = locateElement("rowOne_xpath"+"/td["+i+"]").getText();
				list.add(temp);
			}
			return list;
		}
		return null;
		
	}
	
	public boolean deleteCust(String name) {
		
		if(searchCustByName(name)) {
			
			click("delete_xpath");
			return true;
		}
		return false;
	}

}
