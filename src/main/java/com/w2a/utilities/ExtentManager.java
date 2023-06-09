package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		
		if(extent == null) {
			
			extent = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\w2aExtentReport.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\Resources\\extentConfig\\extentConfigFile.xml"));
			
		}
		
		return extent;
	}

}
