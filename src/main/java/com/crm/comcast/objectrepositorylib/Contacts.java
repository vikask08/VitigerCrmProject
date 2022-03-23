package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	public Contacts (WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactBtn;

	public WebElement getContactBtn() {
		return contactBtn;
	}
}
