package com.testTask.app.config;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testTask.app.util.FrameworkException;
import com.testTask.app.util.Util;

public class TestSetup {

	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static String systemDir = System.getProperty("user.dir");
	public static String resultFolderPath = systemDir + "\\Reports" + "\\" + Util.todaysDate() + "\\";

	@BeforeSuite
	public void initializeWebdriver(ITestContext contextContext) {
		Util.createFolder(resultFolderPath);
		String reportName = resultFolderPath + contextContext.getName() + Util.randomNum() + ".html";
		htmlReporter = new ExtentHtmlReporter(reportName);
		htmlReporter.config().setDocumentTitle("Automation Execution Report");
		htmlReporter.config().setReportName("Test Execution Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeMethod
	public void createTest(ITestResult contextContext) throws FrameworkException {
		test = extent.createTest(contextContext.getMethod().getMethodName(),
				contextContext.getMethod().getMethodName());
		test.info(MarkupHelper.createLabel("Execution started", ExtentColor.ORANGE));
		test.info("BaseURL -- > " + Util.getProperty("BaseURI"));
	}

	@AfterMethod
	public void flushReport() {
		test.info(MarkupHelper.createLabel("Execution finished ", ExtentColor.ORANGE));
		extent.flush();
	}

}
