package com.automation.AccountsPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.page.BasePage;

public class AccountsPage extends BasePage {
	

	
	@FindBy(linkText="Close")WebElement closePopup;
	@FindBy(name="new")WebElement newButton;
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	public AccountsPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkTitle(String expectedTitle) {
		verifyTittle(expectedTitle);
	}


	public WebDriver clickOnNewAccountsButton() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElement(newButton, "New Button");
		return driver;
	}

	public void waitForAccountsTitleToLoad() throws InterruptedException {
		wait.until(ExpectedConditions.titleIs("Accounts: Home ~ Salesforce - Developer Edition"));
	}


	public void handleLightingPopup() {
		
		if (closePopup.isDisplayed()) {
			clickOnElement(closePopup, "Close Popup");
		}
		
	}

	public void waitForAccountsEditTitleToLoad() {
		wait.until(ExpectedConditions.titleIs("Account Edit: New Account ~ Salesforce - Developer Edition"));
		
	}
	
	

	
	
}
