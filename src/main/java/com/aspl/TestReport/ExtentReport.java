package com.aspl.TestReport;

import com.aspl.src.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport extends TestBase {
    
	private static ExtentReports extent;
	private static ExtentTest test;
	public static void main(String[] args) {
   
	ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentReports.html");
    extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
    test = extent.createTest("My First Test", "Sample description");
   }
}

