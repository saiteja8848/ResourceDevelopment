package com.epam.utilites;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestListener implements ITestListener {

	 private ExtentReports extentReports;
	 private ExtentTest test;
	 
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extentReports.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 System.out.println("The name of the testcase passed is :"+result.getName());
		 test.log(LogStatus.PASS,"Test passed");
		 extentReports.endTest(test);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		  System.out.println("The name of the testcase failed is :"+result.getName());
		  test.log(LogStatus.FAIL,result.getThrowable());
		  extentReports.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 System.out.println("The name of the testcase skipped is :"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentReports=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentreport.html",true);
		extentReports.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml"));
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		extentReports.close();
		
	}

	
	
	
}
