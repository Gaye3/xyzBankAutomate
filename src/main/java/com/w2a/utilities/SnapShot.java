package com.w2a.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class SnapShot {
	
	
	public void takeSnapShot(WebDriver driver,String path) {
		
		//Convert the webdriver object to take screeenshot
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		
		//Call getScreenshotAs method to create image file
		File Srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		
		//create a destnation file at ur project level
		File Destfile = new File(path);
		
		//copy the source file to destination file
		try {
			FileUtils.copyFile(Srcfile,Destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
