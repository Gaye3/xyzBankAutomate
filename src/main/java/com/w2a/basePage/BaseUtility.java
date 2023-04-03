package com.w2a.basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.pages.HomePage;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.SnapShot;


public class BaseUtility {
	
	public static WebDriver driver;
	public static Properties config;
	public static Properties OR;
	public static Logger logger = LogManager.getLogger(BaseUtility.class);
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	public static SnapShot snapshot = new SnapShot();
	
	
	public void setUp(String locator) {
		
		if(driver == null) {
			
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\properties\\config.properties");
				config = new Properties();
				config.load(file);
				file.close();
				
				
				file = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\properties\\OR.properties");
				OR = new Properties();
				OR.load(file);
				file.close();
			
				logger.info("Property files loaded");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
			if(config.getProperty(locator).equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\executables\\chromedriver.exe");
				
				ChromeOptions option = new ChromeOptions();
				option.addArguments("incognito");
				option.setExperimentalOption("excludeSwitches",  Arrays.asList("enable-automation"));
				
				
				driver = new ChromeDriver(option);
				
				logger.info("Chrome Driver Launched");
				
			}
			else if(config.getProperty(locator).equals("edge")) {
				
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Resources\\executables\\msedgedriver.exe");
				driver = new EdgeDriver();
				
				logger.info("Edge driver launched");
				
			}
			else if(config.getProperty(locator).equals("gecko")) {
				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				logger.info("Gecko driver launched");
				
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
			
		}
		
	}
	
	public HomePage getUrl(String locator) {
		try {
			
			driver.get(config.getProperty(locator));
			logger.info("Opened the url: "+config.getProperty(locator));
			
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return new HomePage();
	}
	
	public WebElement locateElement(String locator) {
		
		if(locator.endsWith("xpath")) {
			
			return driver.findElement(By.xpath(OR.getProperty(locator)));
			
		}
		else if(locator.endsWith("css")) {
			
			return driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if(locator.endsWith("id")) {
			
			return driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		return null;
		
	}
	
	
	public void click(String locator) {
		
		locateElement(locator).click();
		logger.info("Clicked on the Element: "+locator);
		test.log(LogStatus.INFO, "Clicked on the Element: "+locator);
		
	}
	
	
	public void type(String locator, String data) {
		
		locateElement(locator).sendKeys(data);
		logger.info("Typed the data: "+data+" in "+locator);
		test.log(LogStatus.INFO, "Typed the data: "+data+" in "+locator);
		
	}
	
	
	public void select(String locator,String data) {
		
		Select select = new Select(locateElement(locator));
		select.selectByVisibleText(data);
		
		logger.info("Selected the value: "+data);
		test.log(LogStatus.INFO, "Selected the value: "+data);
		
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	public void tearDown() {
		
		if(driver != null) {
			driver.quit();
			logger.info("Closed the driver");
		}
		
	}
	
}
