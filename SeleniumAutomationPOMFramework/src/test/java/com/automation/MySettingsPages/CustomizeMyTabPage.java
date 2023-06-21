package com.automation.MySettingsPages;

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

public class CustomizeMyTabPage extends BasePage {
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	
	@FindBy(xpath="//span[@id='CustomizeTabs_font']") WebElement customizeMyTabs;	
	@FindBy(xpath="//select[@id='p4']")WebElement customAppDropDown;
	@FindBy(xpath="//select[@id='duel_select_0']")WebElement availableTab;
	@FindBy(xpath="//a/img[@title='Add']")WebElement addButton;
	@FindBy(name="save")WebElement saveButton;
	@FindBy(xpath="//select[@id='p4']")WebElement reCustomAppDropDown;
	@FindBy(xpath="//select[@id='duel_select_1']")WebElement selectedTab;
	@FindBy(xpath="//img[@title='Remove']")WebElement remove;
	@FindBy(name="save")WebElement reSaveButton;
	
	public CustomizeMyTabPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkTitle(String expectedTitle) throws InterruptedException {
		Thread.sleep(2000);
		verifyTittle(expectedTitle);
	}


	public WebDriver clickOnCustomizeMyTab() throws InterruptedException {
		clickOnElement(customizeMyTabs, "Customize MyTabs");
		Thread.sleep(2000);
		return driver;
		
	}

	public void selectSalesForceChatterFromDropDown() throws InterruptedException {
		selectOptionbyVisibleText(customAppDropDown,"Salesforce Chatter");
		Thread.sleep(2000);
	}

	public void selectReportsfromAvailableTab() throws InterruptedException {
		selectOptionbyVisibleText(availableTab, "Reports");
		Thread.sleep(2000);
		
	}

	public void clickOnAddButton() throws InterruptedException {
		
		clickOnElement(addButton, "Add Button");
		Thread.sleep(2000);
		
	}

	public WebDriver clickOnSaveButton() {
		
		clickOnElement(saveButton, "Save Button");
		return driver;
	}

	public void selectSalesForceChatterFromDropDownAgain()throws InterruptedException {
		selectOptionbyVisibleText(customAppDropDown,"Salesforce Chatter");
		Thread.sleep(2000);
	}

	public void selectReportsfromSelectedTab() throws InterruptedException {
		selectOptionbyVisibleText(selectedTab,"Reports");
		Thread.sleep(2000);
	}

	public void clickOnRemoveButton() throws InterruptedException {
		clickOnElement(remove, "remove Button");
		Thread.sleep(2000);
		
	}

	public WebDriver clickOnSaveButtonAgain() throws InterruptedException {
		clickOnElement(reSaveButton, "Save Button");
		Thread.sleep(2000);
		return driver;
	}
	
	
}
