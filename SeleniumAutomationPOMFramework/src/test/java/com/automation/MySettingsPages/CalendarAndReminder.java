package com.automation.MySettingsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.page.BasePage;

public class CalendarAndReminder extends BasePage {
@FindBy(id="testbtn")WebElement openTestRemainder;
	
	
	public CalendarAndReminder(WebDriver driver) {
		super(driver);
	}



	public void clickOnOpenTestRemainder() {
		clickOnElement(openTestRemainder, "Open Test Remainder");
		
	}
	
	
}
