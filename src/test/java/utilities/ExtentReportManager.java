package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	public void onStart(ITestContext testcontext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    repName = "Test-Report" + timeStamp + ".html";
	    
	    sparkReporter = new ExtentSparkReporter("./reports/" + repName );
	    sparkReporter.config().setDocumentTitle("opencart Automation Report");
	    sparkReporter.config().setReportName("opencart Functional Testing");
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    
	    extent  = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    extent.setSystemInfo("Application", "opencart");
	    extent.setSystemInfo("Module", "Admin");
	    extent.setSystemInfo("Sub Module", "customers");
	    extent.setSystemInfo("Operating System",System.getProperty("os.name"));
	    extent.setSystemInfo("User Name", System.getProperty("user.name"));
	    extent.setSystemInfo("Environment", "QA");
	
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		try {
			
			String imgpath = new  BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
    public void onFinish(ITestContext testcontext) {
		extent.flush();
	}
	

}
