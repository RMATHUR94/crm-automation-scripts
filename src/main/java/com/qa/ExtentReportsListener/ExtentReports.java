package com.qa.ExtentReportsListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("FreeCRM TestResult Report");
		sparkReporter.config().setDocumentTitle("FREECRM REPORT");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
//		Properties configProp = new Properties();  
//		File configPropFile = new File(System.getProperty("user.dir")+"src\\main\\java\\com\\crm\\qa\\config\\config.properties");
//		FileInputStream fisConfigProp = new FileInputStream(configPropFile);
//		configProp.load(fisConfigProp);
//		
//		extentReport.setSystemInfo("Application url",configProp.getProperty("url"));
//		extentReport.setSystemInfo("Browser Name",configProp.getProperty("browser"));
//		extentReport.setSystemInfo("Email",configProp.getProperty("username2"));
//		extentReport.setSystemInfo("Password",configProp.getProperty("password"));
//		
		return extentReport;
	}

}
