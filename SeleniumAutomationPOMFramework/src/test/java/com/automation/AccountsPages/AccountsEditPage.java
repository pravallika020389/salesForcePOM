package com.automation.AccountsPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.page.BasePage;

public class AccountsEditPage extends BasePage {
	

	
	
	@FindBy(id="acc2")WebElement accountName;
	@FindBy(id="acc6")WebElement typeDropdown;
	@FindBy(id="00NHs00000Dje6j")WebElement priorityDropdown;
	@FindBy(name="save")WebElement saveButton;
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	
	
	public AccountsEditPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkTitle(String expectedTitle) {
		verifyTittle(expectedTitle);
	}




	public void waitForAccountsEditTitleToLoad() {
		wait.until(ExpectedConditions.titleIs("Account Edit: New Account ~ Salesforce - Developer Edition"));
		
	}

	public void enterAccountName(String eneteredName) {	
		enterText(accountName, eneteredName, "Account name");
		
	}

	public void selectTheType() {
		selectOptionbyValue(typeDropdown,"Technology Partner");
		
	}

	public void selectThepriority() {
		selectOptionbyValue(priorityDropdown,"High");
		
	}

	public WebDriver clickOnSaveButton() {
		clickOnElement(saveButton, "Save Button");
		return driver;
	}
	

	
	
}
