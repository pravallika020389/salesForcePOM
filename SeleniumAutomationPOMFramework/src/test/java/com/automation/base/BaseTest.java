package com.automation.base;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;
import com.automation.utility.log4jUtitlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public WebDriverWait wait;
	protected Logger log;
	protected log4jUtitlity logObject = log4jUtitlity.getInstance();
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	
	@BeforeTest
	public void setUpForBeforeTest() {
		log=logObject.getLogger();
		
	}
	
	@BeforeMethod
	@Parameters("browerName")
	public  void setUpBeforeTestMethod(@Optional("chrome")String brower){
		PropertiesUtility pro =new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		launchBrowser(brower);
		String url=appProp.getProperty("url");
		
		getUrl(url);
		
		
	}
	@AfterMethod
	public  void tearDownAfterTestMethod(){
		driver.close();
	}
	

	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public  void getUrl(String url) {
		driver.get(url);
		log.info(url + " is entered");

	}

	

	public void closeBrowser() {
		driver.close();
		log.info("Browser is closed");

	}

	public void closeAllBrowsers() {
		driver.quit();
		log.info("All Browser are closed");

	}
	
	public File takescreenshot(WebDriver driver) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();  
		    
		TakesScreenshot screenCapture = (TakesScreenshot) driver;
		File srcFile = screenCapture.getScreenshotAs(OutputType.FILE);
		String path = Constants.SCREENSHOTS_DIRECTORY_PATH + "_"+dtf.format(now)+".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFile;

	}


}
