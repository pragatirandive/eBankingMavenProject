package com.ebanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ebanking.testcases.BaseClass;

public class Reporting extends BaseClass implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest logger;

	public void onStart(ITestContext textcontext) {
		String timeStamp = new SimpleDateFormat("ddMMYYYYHHmmss").format(new Date()); // time stamp
		String repName = "Test_report_" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter("E:\\PragatiWorkSpace\\eBankingMavenProject\\test-output\\Reports\\" + repName);
		htmlReporter.loadXMLConfig("E:\\PragatiWorkSpace\\eBankingMavenProject\\test-output\\extent-config.xml");

		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host name", "lacalhost");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("user", "pragati");

		htmlReporter.config().setDocumentTitle("ebankingMavenProject"); // title of project
		htmlReporter.config().setReportName("Functional Test Report"); // name of the report
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {
		logger = report.createTest(tr.getName()); // create new entry in report

		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information
		// send the passed information
	}

	public void onTestFailure(ITestResult tr) {

		logger = report.createTest(tr.getName()); // create new entry
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
		String screenshotPath = ("E:\\PragatiWorkSpace\\eBankingMavenProject\\screenshots" + tr.getName() + ".png");
		File file = new File(screenshotPath);

		if (file.exists()) {
			try {
				logger.fail("screenshot is below : " + logger.addScreenCaptureFromPath(screenshotPath));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = report.createTest(tr.getName()); // create new entry in report

		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finished test");
		report.flush();
		
	}

}
