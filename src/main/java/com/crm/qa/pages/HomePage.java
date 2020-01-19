package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	//all are page libraries which we are created
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage(){
		//how will you initalize your PageFactory(all the weblements with the help of driver)
		//we will initalize with the help of a method initElements(driver, this)
		//and here this pointing towards current class object which is TestBase class
		PageFactory.initElements(driver, this);
			
		}

	
	public String verifyHomePageTitle(){
		return driver.getTitle();	
		
	}
	
	public ContactsPage clickOnContactsLink(){
		//here we can write switch to condition or in ContactsPageTest class
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLable.isDisplayed();
	}
	
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	
	
	
}
