package com.automation.MySettingsPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.page.BasePage;

public class LoginHistoryPage extends BasePage {
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	@FindBy(linkText="Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")WebElement downloadLink;
	


	public LoginHistoryPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkTitle(String expectedTitle) throws InterruptedException {
		Thread.sleep(2000);
		verifyTittle(expectedTitle);
	}


	public WebDriver clickOnDownloadLink() throws InterruptedException {
		clickOnElement(downloadLink, "downloadLink");
		Thread.sleep(2000);
		return driver;
	}

	

	
	
}
