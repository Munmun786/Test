package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	//object
	@FindBy(xpath = "//span[text()='My Account']")
	 private WebElement  myAccountPag;
	
	@FindBy(linkText = "Login")
	private WebElement loginPag;

	 WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	//action
	
	public void clickOnMyAccount() {
		myAccountPag.click();
		
	}
	
	public void clickOnLogin() {
		loginPag.click();
	}
	
	
}
