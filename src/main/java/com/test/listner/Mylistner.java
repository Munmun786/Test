package com.test.listner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utiliti.ExtendsReports;

public class Mylistner implements ITestListener {
	
	ExtentReports  extentReport;
	 ExtentTest extentTest;
	 
	@Override
	public void onStart(ITestContext context) {
		ExtentReports  extentReport = ExtendsReports.getExtendReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		    String testName = result.getName();
		     extentTest =extentReport.createTest(testName);
		    extentTest.log(Status.INFO,  testName + "test Start");
		    
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		        String  testName=result.getName();
		        extentTest.log(Status.PASS, testName + "test pass");
		        
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
	   WebDriver driver = null ;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	File srcScreenshot	=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir")+ "\\ScreenShot"+ testName+".png";
		try {
            Files.copy(srcScreenshot.toPath(), Paths.get(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
	
		  extentTest.addScreenCaptureFromPath(screenShotPath);
	extentTest.log(Status.INFO,result.getThrowable() );
	 extentTest.log(Status.FAIL,testName + "got fail");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		   String testName=result.getName();
		   extentTest.log(Status.INFO, result.getThrowable());
		   extentTest.log(Status.SKIP, testName + "got skip");
		
	}



	@Override
	public void onFinish(ITestContext context) {
	
      extentReport.flush();		
	}

}
