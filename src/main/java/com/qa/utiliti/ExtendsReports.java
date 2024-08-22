package com.qa.utiliti;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReports {

	public static ExtentReports  getExtendReport() {
		
		
          ExtentReports  extentReport =new ExtentReports();
           File  extendReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtendReport\\extenTReport.html");
          ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extendReportFile);
          sparkReporter.config().setTheme(Theme.DARK);
          sparkReporter.config().setReportName("testReport");
		sparkReporter.config().setDocumentTitle("tstTitle");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYY hh:mm:aaa");
		
		extentReport.attachReporter (sparkReporter);
		
	  Properties configurProp=new Properties();
	      File ConfigFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\config\\config.properties");
	      
	      try {
	    	  FileInputStream configFish   =new FileInputStream(ConfigFile);
	           configurProp.load(configFish);
	  
		} catch (Throwable e) {
		e.printStackTrace();
		}
	             extentReport.setSystemInfo("Application Url", configurProp.getProperty("url"));
	             extentReport.setSystemInfo("Browser", configurProp.getProperty("browser"));
	             extentReport.setSystemInfo("Email", configurProp.getProperty("email"));
	              extentReport.setSystemInfo("Password",configurProp.getProperty("password"));
	              extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
	              extentReport.setSystemInfo("UserName", System.getProperty("user.name"));
	              extentReport.setSystemInfo("JAVA vesrsion", System.getProperty("java.version"));
	              
	      return extentReport;
	      
	      
	}
	
	 
}
