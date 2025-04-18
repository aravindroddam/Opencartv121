package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.Baseclass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Extentreportmanager implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	String repName;
	
	public void onStart(ITestContext context) {
		

		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		
		repName="Test-Report-"+timestamp+".html";  //report name alongwith timestamp
		
		
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\USER\\eclipse-workspace\\Opencartv121\\reports\\"+repName);
		htmlReporter.config().setDocumentTitle("AutomationReport");
		htmlReporter.config().setReportName("FunctionalTesting");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("user name",System.getProperty("user.name"));    //populating user of the report created
		extent.setSystemInfo("Applocation", "Orange Hrm");
		extent.setSystemInfo("Environment","QA");
		
	
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating systme", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
	}
	public void onTestSuccess(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
	test.log(Status.PASS,"Test case is passed:"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
	test=extent.createTest(result.getClass().getName());
	test.log(Status.FAIL,"Test case is failed:"+result.getName());
	
	
	try {
		String imgpath=new Baseclass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getClass().getName());
	
	test.log(Status.SKIP,"Test case is skipped:"+result.getName());
	
	
	
	
	}

	public void onFinish(ITestContext context) {
extent.flush();

String pathofExtentreport="C:\\Users\\USER\\eclipse-workspace\\Opencartv121\\reports\\"+repName;
File extentReport=new File(pathofExtentreport);
try
{
Desktop.getDesktop().browse(extentReport.toURI());
}
catch(IOException e)
{
e.printStackTrace();	
	
}


}}
