package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	//----remote repository--
	//https://github.com/raviselinium/FreeCRMTest.git 
	
	
	//it is used as inheritance property
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		//here properties code i wrotten inside the TestBase constructor
		
		try{
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:/selinium_trials/FreeCRMTest/src/main/java/com/crm"
									+"/qa/config/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	
public static void initialization(){
	
	String browserName =  prop.getProperty("browser");
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","F:\\seliniumzipFiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver","F:\\seliniumzipFiles\\chromedriver_win32\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	
	}
		

}
