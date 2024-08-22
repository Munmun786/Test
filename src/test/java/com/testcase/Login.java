package com.testcase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utiliti.Utilities;
import com.test.base.Base;
import com.test.pages.AccountPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class Login extends Base {

	public  WebDriver driver;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = allBrowser(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnLogin();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validData")
	public void verifyLogin(String email, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		   loginPage.emailFild(email);
		loginPage.passwordFild(password);
		loginPage.clickButton();

		
		  AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.succesMasge());
	}

	@DataProvider(name = "validData")
	public Object[][] dataSupply() {
		Object[][] data = Utilities.getDataFromeExel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyInvalid() {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.dateTime());
		driver.findElement(By.id("input-password")).sendKeys("munmun@97");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWar = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectWar = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertTrue(actualWar.contains(expectWar), "Expected warning is not displayed");
	}

	@Test(priority = 3)
	public void verifyWithInvalidEmailAndValidPass() {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.dateTime());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWar = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectWar = prop.getProperty("emailWarningMsg");

		Assert.assertTrue(actualWar.contains(expectWar), "Expected warning is not displayed");
	}

	@Test(priority = 4)
	public void verifyWithValidEmailAndInvalidPass() {
		
		driver.findElement(By.id("input-email")).sendKeys("munmupradhan686@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWar = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectWar = prop.getProperty("emailWarningMsg");

		Assert.assertTrue(actualWar.contains(expectWar), "Expected warning is not displayed");
	}

	@Test(priority = 5)
	public void verifyWithoutCredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWar = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectWar = prop.getProperty("emailWarningMsg");

		Assert.assertTrue(actualWar.contains(expectWar), "Expected warning is not displayed");
	}
}
