package com.crm.qa.listeners;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.qa.TestBase;
import com.qa.ExtentReportsListener.ExtentReporterNG;

public class MyListeners extends TestBase implements ITestListener,WebDriverEventListener{

	 ExtentReports extentReport;
	 ExtentTest extentTest;

	
	@Override
	public void onStart(ITestContext context) {
		
		try {
			extentReport = ExtentReporterNG.generateExtentReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String Testname = result.getTestName();
		extentTest = extentReport.createTest(Testname);
		extentTest.log(Status.INFO, Testname +"started executing");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String Testname = result.getName(); 
		extentTest.log(Status.PASS, Testname +"got Successfully Executed");
		
		//System.out.println(Testname + "Got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String Testname = result.getName(); 
		
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,Testname +"Got Failed");
		
//		System.out.println(Testname + "Got Failed");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
       String testName = result.getName();
		
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP,testName + "Got Skiped");
		
//		System.out.println(testName + "Got skipped");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP,testName + "Got Failed due to timeout");
//		System.out.println(testName + "Got failed due to timeout");
//		System.out.println(result.getThrowable());
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
	}


	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
   
}
