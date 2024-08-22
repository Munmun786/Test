package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(id = "input-email") 
   private	WebElement emailAddresField;
	
	
	@FindBy(id = "input-password")
	private WebElement passwordfield;
	
	
	@FindBy(xpath = "//input[@value='Login']")
           private  WebElement	loginBuuton;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void emailFild(String emailText) {
		
		emailAddresField.sendKeys(emailText);
	}
	 
	public void passwordFild(String Pass) {
		passwordfield.sendKeys(Pass);
	}
	
	public void clickButton() {
		loginBuuton.click();
	}
	
	
}
