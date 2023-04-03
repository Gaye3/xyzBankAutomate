package com.w2a.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.basePage.BaseUtility;

public class OpenAccount extends BaseUtility{
	

	public void selectCustomerName(String custName) {
		
		click("customer_id");
		select("customer_id",custName);
		
	}
	
	public void selectCurrency(String currency) {
		
		click("currency_id");
		select("currency_id",currency);
		
	}
	
	public void clickProcess() {
		
		click("process_xpath");
		
	}
	
	public boolean isAlertDisplay() {
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
	
	public Customers clickCustomers() {
		
		click("customers_xpath");
		return new Customers();
		
	}
	
}
