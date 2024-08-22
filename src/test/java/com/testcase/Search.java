package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.test.base.Base;



public class Search extends Base {

	WebDriver driver;
	
	public Search() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		driver =allBrowser(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void searWithVaildC() {
		
		  
	driver.findElement(By.name("search")).sendKeys("HP");
	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		
	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void searchWithInvalid() {
		
		driver.findElement(By.name("search")).sendKeys("demo");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
			
		String actual	 =driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actual, "There is no product that matches the search criteria.");
		
	}
	
	@Test(priority = 3)
	
	public void searchWithNoProduct() {
		
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
			
		String actual	 =driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actual, "There is no product that matches the search criteria.");
		
		
	}
	
	
}
