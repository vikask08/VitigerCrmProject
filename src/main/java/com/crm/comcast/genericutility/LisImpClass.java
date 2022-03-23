package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LisImpClass implements ITestListener{
	 ExtentReports reports;
	 ExtentTest test;
	 
	
	  @Override		
	    public void onTestSkipped(ITestResult result) {					
	       test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
	       test.log(Status.SKIP, result.getThrowable());	
	    }	
	  @Override		
	    public void onTestStart(ITestResult result) {					
	       test=reports.createTest(result.getMethod().getMethodName());				
	        		
	    }		


	    @Override		
	    public void onTestSuccess(ITestResult arg0) {					
	       test.log(Status.PASS, arg0.getMethod().getMethodName()+" is passed");			
	        		
	    }	

	  @Override		
	    public void onStart(ITestContext arg0) {					
		  ExtentSparkReporter sparkReporter=new ExtentSparkReporter("./ExtentReport.html");
	        sparkReporter.config().setTheme(Theme.DARK);
	        sparkReporter.config().setDocumentTitle("Vtiger Automation");
	        sparkReporter.config().setReportName("Execution Report");
	         reports=new ExtentReports();
	        reports.attachReporter(sparkReporter);
	        reports.setSystemInfo("OS","Windows11");
	        reports.setSystemInfo("url","http://example.com");
	        reports.setSystemInfo("Reporter name","vikas");
	    }	
	  
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseAnnotationClass.sDriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File destFile= new File("./ScreenShot/"+testName+".png");
		try {
		FileUtils.copyFile(srcFile,destFile);
		}
		catch(IOException e){
	}
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(destFile.getAbsolutePath());
		
	}
	 @Override		
	    public void onFinish(ITestContext arg0) {					
	       	reports.flush();		
	        		
	    }		
}