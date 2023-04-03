package com.w2a.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.basePage.BaseUtility;

public class AddCustomer extends BaseUtility{
	
	
	public void clickAddCustomer() {
		
		click("addCust_xpath");
		
	}
	
	public void typeFirstName(String name) {
		
		type("firstName_xpath",name);
		
	}
	
	public void typeLastName(String name) {
		
		type("lastName_xpath",name);
		
	}
	
	public void typePostCode(String postCode) {
		
		type("postCode_xpath",postCode);
		
	}
	
	public void clickSubmit() {
		
		click("submit_xpath");
		
	}
	
	public boolean isAlertDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert alert = driver.switchTo().alert();
			logger.info(alert.getText());
			test.log(LogStatus.INFO, alert.getText());
			alert.accept();
			
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}

	public OpenAccount clickOpenAcc() {
		
		click("openAcc_xpath");
		return new OpenAccount();
	}
	
	public Customers clickCustomers() {
		
		click("customers_xpath");
		return new Customers();
	}
	
	
}
