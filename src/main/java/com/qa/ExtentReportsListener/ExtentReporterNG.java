package com.qa.ExtentReportsListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG implements ITestNGListener{
//	private static final Logger logger = LoggerFactory.getLogger(ExtentReporterNG.class);
//
//	private ExtentReports extent;
//	private ExtentTest test;
//	private ExtentHtmlReporter htmlReporter;
//	
//	@BeforeSuite
//	public void setup() {
//		logger.info(":::::::::::::Inside setup:::::::");
//		htmlReporter = new ExtentHtmlReporter("extent-report.html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//	}
//
//	@AfterMethod
//	public void tearDown(ITestResult result) {
//		logger.info(":::::::::::::Inside tearDown:::::::");
//		if(result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, "Test case failed: " + result.getName());
//		} else if(result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, "Test case Passed: " + result.getName());
//		} else {
//			test.log(Status.SKIP, "Test case Skipped: " + result.getName());
//		}
//		//for (ISuite suite : suites) {
//		//	Map<String, ISuiteResult> result = suite.getResults();
//
//			//for (ISuiteResult r : result.values()) {
//				//ITestContext context = r.getTestContext();
//		
//		test = extent.createTest("Rahul-FreeCRM-TestReport","Generate test report for Free CRM");
//		test.log(Status.INFO, "This step shows status");
//		test.pass("Test Passed");
//
//				//buildTestNodes(context.getPassedTests(),LogStatus.PASS);
//				//buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
//				//buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
//			//}
//		//}
//
//		//extent.close();
//	}
//	
//	@AfterSuite
//	public void flushreport() {
//		logger.info(":::::::::::::Inside flushreport:::::::");
//		extent.flush();
//	}

	
	public static ExtentReports generateExtentReport() throws IOException
	{
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("FreeCRM TestResult Report");
		sparkReporter.config().setDocumentTitle("FREECRM REPORT");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();  
		File configPropFile = new File(System.getProperty("user.dir")+"src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		FileInputStream fisConfigProp = new FileInputStream(configPropFile);
		configProp.load(fisConfigProp);
		extentReport.setSystemInfo("Application url",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name",configProp.getProperty("browser"));
		extentReport.setSystemInfo("Email",configProp.getProperty("username2"));
		extentReport.setSystemInfo("Password",configProp.getProperty("password"));
	
	    return extentReport;
	}
	
}

