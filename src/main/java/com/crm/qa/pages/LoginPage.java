package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
//1 to 1 mapping it should be
//for each and every pages we have to create separate java class
//here we will use PageFactory-- or -- ObjecteRepository
//so for that we will use @FindBy annotation and many more annotations
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//ho to initalize all the object repository which we are using 
	//here we are initalizing webelements with the help of PageFactory
	
	
	//initalizing the Page Object
	public LoginPage(){
		//how will you initalize your PageFactory(all the weblements with the help of driver)
		//we will initalize with the help of a method initElements(driver, this)
		//and here this pointing towards current class object which is TestBase class
		PageFactory.initElements(driver, this);
			
		}
	//different actions or functionality which are avilable on login page
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean validateCRmImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
}
