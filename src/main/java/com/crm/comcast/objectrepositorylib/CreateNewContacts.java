package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
/**
 * This is Object Repository Library Class to Create New Contact
 * @author VikasK
 *
 */
public class CreateNewContacts extends WebDriverUtility {
	/**
	 * Initialization of Object Repository Library
	 * @param driver
	 */
	WebDriver driver=null;
	public CreateNewContacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(name="lastname")
	private WebElement contactsEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	/**
	 * Used to Create Mandate Information
	 * @param lastName
	 */
	public void createContact(String lastName) {
		contactsEdt.sendKeys(lastName);
		saveBtn.click();
		
	}
	/**
	 *  Used to Create Mandate Information and Performing Actions
	 * @param lastName
	 * @param orgName
	 */
	public void createContact(String lastName,String orgName) {
		contactsEdt.sendKeys(lastName);
		selectBtn.click();
		switchToWindow(driver, "Accounts&action");
		
		Organizations org=new Organizations(driver);
		org.getSearchEdt().sendKeys(orgName);
		org.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
	
}
