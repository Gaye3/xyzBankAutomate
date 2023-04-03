package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.basePage.BaseUtility;

public class CustomListener extends BaseUtility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		//ITestListener.super.onTestStart(result);
		test = report.startTest(result.getName().toUpperCase());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getName()+" Test Passed");
		test.log(LogStatus.PASS, result.getName()+" Test Passed");
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getName()+" Test Failed");
		test.log(LogStatus.FAIL, result.getName()+" Test Failed with: "+result.getThrowable());
		
		snapshot.takeSnapShot(driver, System.getProperty("user.dir")+"\\FailedSnapshots\\"+result.getName()+".png");
		test.log(LogStatus.FAIL, test.addScreenCapture(System.getProperty("user.dir")+"\\FailedSnapShots\\"+result.getName()+".png"));
		
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getName()+" Test Skipped");
		test.log(LogStatus.SKIP, result.getName()+" Test Skipped with: "+result.getThrowable());
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	//@Override
	//public void onTestFailedWithTimeout(ITestResult result) {
		//ITestListener.super.onTestFailedWithTimeout(result);
	//}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
	
	
}
