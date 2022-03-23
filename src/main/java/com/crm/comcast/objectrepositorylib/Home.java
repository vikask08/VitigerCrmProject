package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public WebDriver driver=null;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}
	
	public void logout() {
		Actions a=new Actions(driver);
		a.moveToElement(adminstratorImg).perform();
		signOut.click();
	}
}
