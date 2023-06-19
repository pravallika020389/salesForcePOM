package com.automation.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.AccountsPages.AccountsEditPage;
import com.automation.AccountsPages.AccountsPage;
import com.automation.AccountsPages.NewAccountsPage;
import com.automation.HomePages.HomePage;
import com.automation.LoginPages.CheckMailPage;
import com.automation.LoginPages.ForgotPasswordPage;
import com.automation.LoginPages.LoginPage;
import com.automation.LoginPages.ReLoginPage;
import com.automation.base.BaseTest;
import com.automation.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScripts extends BaseTest {

	@Test

	public void login_Error_Message_1() throws InterruptedException {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(userId);
		loginPage.clearPswdField();
		driver = loginPage.clickLoginButton();

		String actualErrorMsg = loginPage.getErrorMsg();
		String expectedErrorMsg = appProp.getProperty("login.error");

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	@Test
	public void login_Success_2() throws InterruptedException, AWTException {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(userId);
		loginPage.enterPassword(password);
		driver = loginPage.clickLoginButton();

		/// should pass the updated driver
		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		String actualHomeTitle = homePage.getPagetitle();
		String expectedHomeTitle = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualHomeTitle, expectedHomeTitle);
	}
@Test
	
	public void check_Remember_Me_03() throws InterruptedException {
		PropertiesUtility pro =new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(userId);
		loginPage.enterPassword(password);
		loginPage.checkRememberMe();
		driver = loginPage.clickLoginButton();

		/// should pass the updated driver
		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		homePage.checkTitle("Home Page ~ Salesforce - Developer Edition");
		homePage.waitForMenuToBeClickable();
		homePage.clickUserMenu();
		homePage.waitForLogoutToBeClickable();
		driver = homePage.clickOnLogout();
		ReLoginPage reLoginPage = new ReLoginPage(driver);
		reLoginPage.checkTitle("Login | Salesforce");
		reLoginPage.waitForReloginfieldIsVisible();
		
		String actualUserId = reLoginPage.getLoginText();
		Assert.assertEquals(userId,actualUserId);
		

	}
	@Test
	
	public void Forgot_Password_04A() throws InterruptedException, AWTException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.random.userid");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.waitForForgotPswdToBeClickable();
		driver=loginPage.clickForgotPswd();
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.waitForUsernameFieldIsVisible();
		forgotPasswordPage.enterUserName(userId);
		driver=forgotPasswordPage.clickContinueButton();
		CheckMailPage checkMailPage = new CheckMailPage(driver);
		checkMailPage.waitforCheckMailPageTitle();
		Assert.assertTrue(checkMailPage.checkforReturnToLoginButton());
	}
	
	@Test
	
	public void Forgot_Password_04B() throws InterruptedException, IOException {
		PropertiesUtility pro =new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String invalidUserId = appProp.getProperty("login.invalid.userid");
		String invalidPassword = appProp.getProperty("login.invalid.password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(invalidUserId);
		loginPage.enterPassword(invalidPassword);
		driver = loginPage.clickLoginButton();
		String actualErrorMsg = loginPage.getErrorMsg();
		String expectedErrorMsg = appProp.getProperty("invalid.login.error");
		Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
	}
	
	@Test
	public void user_Menu_dropdown_05() throws InterruptedException {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(userId);
		loginPage.enterPassword(password);
		driver = loginPage.clickLoginButton();

		/// should pass the updated driver
		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		homePage.checkTitle("Home Page ~ Salesforce - Developer Edition");
		homePage.waitForMenuToBeClickable();
		homePage.clickUserMenu();
		List<String> actualDropdown=homePage.getActualDropdownList();
		List<String> expectedDropdown = new ArrayList<String>(Arrays.asList("My Profile", "My Settings",
				"Developer Console", "Switch to Lightning Experience", "Logout"));
		Assert.assertEquals(actualDropdown, expectedDropdown);
	}
	
	@Test
	public void logout_09() throws InterruptedException {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(userId);
		loginPage.enterPassword(password);
		driver = loginPage.clickLoginButton();

		/// should pass the updated driver
		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		homePage.checkTitle("Home Page ~ Salesforce - Developer Edition");
		homePage.waitForMenuToBeClickable();
		homePage.clickUserMenu();
		driver = homePage.clickOnLogout();
		ReLoginPage reLoginPage = new ReLoginPage(driver);
		Thread.sleep(2000);
		String actualLoginTitle = reLoginPage.getPagetitle();
		String expectedLoginTitle = "Login | Salesforce";
		Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	}

	@Test

	public void createAccounts_10() throws InterruptedException {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkTitle("Login | Salesforce");
		loginPage.enterUserName(userId);
		loginPage.enterPassword(password);
		driver = loginPage.clickLoginButton();

		/// should pass the updated driver
		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		homePage.checkTitle("Home Page ~ Salesforce - Developer Edition");
		Thread.sleep(2000);
		driver = homePage.clickOnAccountsTab();
		AccountsPage accountsPage = new AccountsPage(driver);
		accountsPage.waitForPageLoad(60);
		accountsPage.handleLightingPopup();
		accountsPage.waitForAccountsTitleToLoad();
		driver= accountsPage.clickOnNewAccountsButton();
		AccountsEditPage accountsEditPage = new AccountsEditPage(driver);
		accountsEditPage.waitForAccountsEditTitleToLoad();
		String eneteredName = "hello";
		accountsEditPage.enterAccountName(eneteredName);
		accountsEditPage.selectTheType();
		accountsEditPage.selectThepriority();
		driver=accountsEditPage.clickOnSaveButton();
		NewAccountsPage newAccountsPage = new NewAccountsPage(driver);
		String expectedTitle = "Account: " + eneteredName + " ~ Salesforce - Developer Edition";
		String actualTitle = newAccountsPage.getPagetitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		closeBrowser();

	}



}
