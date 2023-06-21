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

public class SettingsPage extends BasePage {
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	@FindBy(xpath="//span[@id='PersonalInfo_font']")WebElement personalTab;
	@FindBy(xpath="//span[@id='LoginHistory_font']")WebElement loginHistory;
	@FindBy(linkText="Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")WebElement downloadLink;
	@FindBy(xpath="//span[@id='DisplayAndLayout_font']")WebElement displayLayouttab;
	@FindBy(xpath="//span[@id='CustomizeTabs_font']") WebElement customizeMyTabs;	
	@FindBy(xpath="//select[@id='p4']")WebElement customAppDropDown;
	@FindBy(xpath="//select[@id='duel_select_0']")WebElement availableTab;
	@FindBy(xpath="//a/img[@title='Add']")WebElement addButton;
	@FindBy(xpath="\"//span[@id='DisplayAndLayout_font']\"")WebElement reDisplayLayouttab;
	@FindBy(xpath="//span[@id='CustomizeTabs_font']") WebElement reCustomizeMyTabs;
	@FindBy(xpath="//span[@id='EmailSetup_font']") WebElement emailTab;
	@FindBy(xpath="//span[@id='EmailSetup_font']")WebElement emailSetting;
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']")WebElement calAndRemindr;
	@FindBy(xpath="//span[@id='Reminders_font']")WebElement activityRemainder;
	
	
	public SettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkTitle(String expectedTitle) throws InterruptedException {
		Thread.sleep(2000);
		verifyTittle(expectedTitle);
	}


	public void clickOnPersonalTab() throws InterruptedException {
		clickOnElement(personalTab, "Personal Tab");
		Thread.sleep(2000);
		
	}

	public WebDriver clickOnLoginHistory() throws InterruptedException {
		clickOnElement(loginHistory, "Login History");
		Thread.sleep(2000);
		return driver;
		
	}

	public void clickOnDownloadLink() throws InterruptedException {
		clickOnElement(downloadLink, "downloadLink");
		Thread.sleep(2000);
		
	}

	public void clickOnDisplayLayoutTab() throws InterruptedException {
		clickOnElement(displayLayouttab, "Display Layouttab");
		Thread.sleep(2000);
		
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

	public void clickOnDisplayLayoutTabAgain() throws InterruptedException {
		clickOnElement(reDisplayLayouttab, "Display Layouttab");
		Thread.sleep(2000);
		
	}

	public WebDriver clickOnCustomizeMyTabAgain() throws InterruptedException {
		clickOnElement(reCustomizeMyTabs, "Customize MyTabs");
		Thread.sleep(2000);
		return driver;
	}

	public void clickOnEmailTab() throws InterruptedException {
		clickOnElement(emailTab, "email Tab");
		Thread.sleep(2000);
		
	}

	public WebDriver clickOnEmailSettings() throws InterruptedException {
		clickOnElement(emailSetting, "email Setting");
		Thread.sleep(1000);
		return driver;
	}

	public void clickOnCalendarAndReminder() throws InterruptedException {
		clickOnElement(calAndRemindr, "Calendar And Remainder");
		Thread.sleep(2000);
		
	}

	public WebDriver clickOnActivityReminder() throws InterruptedException {
		clickOnElement(activityRemainder, "Activity Remainder");
		Thread.sleep(2000);
		return driver;
	}
	
	

	
	
}
