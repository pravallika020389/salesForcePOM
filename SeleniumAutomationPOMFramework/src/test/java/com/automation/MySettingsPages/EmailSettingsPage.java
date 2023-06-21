package com.automation.MySettingsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.page.BasePage;

public class EmailSettingsPage extends BasePage {
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	
	@FindBy(id="auto_bcc1")WebElement bccRadio;
	
	
	public EmailSettingsPage(WebDriver driver) {
		super(driver);
	}
	


	public WebDriver selectBccRadioButton() {
		
		if (bccRadio.isSelected()) {
			System.out.println("BCC is already selected as YES");
		} else {
			bccRadio.click();
			System.out.println("BCC is selected as YES");
		}

		return driver;
	}
	
	
}
