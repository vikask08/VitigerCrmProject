package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement sucessfulMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industrySucessMsg;

	public WebElement getSucessfulMsg() {
		return sucessfulMsg;
	}

	public WebElement getIndustrySucessMsg() {
		return industrySucessMsg;
	}
}
