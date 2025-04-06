package ebay.ListenerUtility;

import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ebay.BaseClassUtility.BaseClass;
import ebay.WebDriverUtility.UtilityClass;



	public class ListenerImplementationTest implements ITestListener,ISuiteListener {
		public ExtentReports report;
		ExtentTest test;

		@Override
		public void onStart(ISuite suite) {
			System.out.println("Report Configuration");
			String time= new Date().toString().replace(" ", "_").replace(":", "_");
			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("Online shopping application");
			spark.config().setReportName("Ebay Report");
			spark.config().setTheme(Theme.DARK);

			// add env information and create test
			 report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "windows -10 home");
			report.setSystemInfo("Browser", "chrome-122.0.6261.112");
		}

		@Override
		public void onFinish(ISuite suite) {
			System.out.println("Report Backup");
			report.flush();
		}

		@Override
		public void onTestStart(ITestResult result) {
			System.out.println(result.getMethod().getMethodName());
			 test = report.createTest(result.getMethod().getMethodName());
			 UtilityClass.setTest(test);
			 test.log(Status.INFO,result.getMethod().getMethodName()+" is STARTED");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			String testname=result.getMethod().getMethodName();
			String time= new Date().toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
			String filepath=ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(filepath,testname+"_"+time);
			 test.log(Status.PASS,result.getMethod().getMethodName()+" is COMPLETED");	}

		@Override
		public void onTestFailure(ITestResult result) {
			String testname=result.getMethod().getMethodName();
			String time= new Date().toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
			String filepath=ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(filepath,testname+"_"+time);
			 test.log(Status.FAIL,result.getMethod().getMethodName()+" is FAILED");		
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			 test.log(Status.SKIP,result.getMethod().getMethodName()+"is SKIPPED");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			
		}

		@Override
		public void onStart(ITestContext context) {
			
		}

		@Override
		public void onFinish(ITestContext context) {
			
		}

	}


