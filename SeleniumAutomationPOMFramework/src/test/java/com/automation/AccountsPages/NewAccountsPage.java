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

public class NewAccountsPage extends BasePage {
	
	public  WebDriverWait wait  = new WebDriverWait(driver, 40);
	
	
	public NewAccountsPage(WebDriver driver) {
		super(driver);
	}
	
}