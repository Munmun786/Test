package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utiliti.Utilities;

public class Base {

	
	WebDriver driver;
	public Properties prop;
	public Properties propData;
	
	
	
	public Base() {
		
		 prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\config\\config.properties");
		
		
		 
		 propData = new Properties();
		File propFile2 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\testdata\\testdata.properties");
		try {
			FileInputStream fis2 = new FileInputStream(propFile2);
			propData.load(fis2);
		} catch (Throwable e) {
		
			e.printStackTrace();;
			// TODO: handle exception
		}
		
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	public WebDriver allBrowser(String browserName) {
		

		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
	     else if (browserName.equalsIgnoreCase("firefox")) {
			
	    	 driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
		}
		
		
		 
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicity_wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_load));
		driver.get(prop.getProperty("url"));
		
		
		return driver;
	}
	
		
		
	}
	

