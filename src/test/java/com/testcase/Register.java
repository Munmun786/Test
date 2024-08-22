package com.testcase;

import java.sql.Driver;
import java.time.Duration;

import javax.naming.ldap.StartTlsRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.utiliti.Utilities;
import com.test.base.Base;

public class Register extends Base {

	public WebDriver driver ;
	
	 public Register() {
		 
		 super();
	 }
	 
	 
	 
	 
	 @BeforeMethod
	 public void setUp() {
		
		driver= allBrowser(prop.getProperty("browser"));
		 
		 
	}
	 
	 
	 
	 @AfterMethod
	public void quit() {
		
		driver.quit();
		
	}
	
	
	@Test(priority = 1)
	public void registerWithCridential() {
		
		
		 
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 driver.findElement(By.id("input-firstname")).sendKeys("munmun");
		 driver.findElement(By.id("input-lastname")).sendKeys("pradhan");
		 driver.findElement(By.id("input-email")).sendKeys(Utilities.dateTime());
		 driver.findElement(By.id("input-telephone")).sendKeys("9090909090");
		 driver.findElement(By.id("input-password")).sendKeys("munum123");
		 driver.findElement(By.id("input-confirm")).sendKeys("munmun123");
		 driver.findElement(By.name("agree")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		 String actualResult = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		 
		 Assert.assertEquals(actualResult  , "Your Account Has Been Created!" , "not showing");
		 
	}
	
	@Test(priority = 2)
	public void registerWithAllCridential() {
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 driver.findElement(By.id("input-firstname")).sendKeys("munmun");
		 driver.findElement(By.id("input-lastname")).sendKeys("pradhan");
		 driver.findElement(By.id("input-email")).sendKeys(Utilities.dateTime());
		 driver.findElement(By.id("input-telephone")).sendKeys("9090909090");
		 driver.findElement(By.id("input-password")).sendKeys("munum123");
		 driver.findElement(By.id("input-confirm")).sendKeys("munmun123");
		 driver.findElement(By.name("newsletter")).click();
		 driver.findElement(By.name("agree")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		 String actualResult = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		 
		 Assert.assertEquals(actualResult  , "Your Account Has Been Created!" , "not showing");
		 
	}
	
	@Test(priority = 3)
	public void registerWithExistEmailCridential() {
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 driver.findElement(By.id("input-firstname")).sendKeys("munmun");
		 driver.findElement(By.id("input-lastname")).sendKeys("pradhan");
		 driver.findElement(By.id("input-email")).sendKeys("munmunpradhan786@gmail.com");
		 driver.findElement(By.id("input-telephone")).sendKeys("9090909090");
		 driver.findElement(By.id("input-password")).sendKeys("munum123");
		 driver.findElement(By.id("input-confirm")).sendKeys("munmun123");
		 driver.findElement(By.name("newsletter")).click();
		 driver.findElement(By.name("agree")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		 String actualResult = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 
		 Assert.assertEquals(actualResult  , "Warning: E-Mail Address is already registered!" , "not showing");
		 
	}
	
	
	@Test(priority = 4)
	public void registerDirect() {
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		 String actualResult = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 
		 Assert.assertEquals(actualResult  , "Warning: You must agree to the Privacy Policy!!" , "not showing");
		 
		 
		String  firstNameRest = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div')]")).getText();
		Assert.assertEquals(firstNameRest  , "First Name must be between 1 and 32 characters!" , "not showing");
	}
	
	
	
}
