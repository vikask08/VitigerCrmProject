package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	public ContactInformation (WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement sucessfulMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameIcon;

	public WebElement getSucessfulMsg() {
		return sucessfulMsg;
	}

	public WebElement getOrgNameIcon() {
		return orgNameIcon;
	}
	
}
