package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	//all are page libraries which we are created
		@FindBy(xpath="//td[contains(text(),'Contacts')]")
		WebElement contactsLabel;
	
		
		//Initializing the page objects
		public ContactsPage(){
			PageFactory.initElements(driver, this);
		}
		
		
		public boolean verifyContactsLabel(){
			return contactsLabel.isDisplayed();
		}
	
		
		public void selectContactsByName(String name){
			driver.findElement(By.xpath("//a[text()= '"+name+"']//parent::td[@class='datailstrow']"
					+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		}
		

		
}
