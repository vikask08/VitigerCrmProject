package com.crm.comcast.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.ContactInformation;
import com.crm.comcast.objectrepositorylib.Contacts;
import com.crm.comcast.objectrepositorylib.CreateNewContacts;
import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.OrganizationInfo;
import com.crm.comcast.objectrepositorylib.Organizations;
/**
 * This class contains testNG specific methods for CotactsTest
 * @author VikasK
 *
 */
public class ContactTests extends BaseAnnotationClass{
	/**
	 * This method to create Contacts
	 * @param args
	 * @throws Throwable
	 */
	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable {

		//Read Test Data
		String lastName = eLib.getDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();

		//Navigate to Home Page
		Home hp=new Home(driver);
		hp.getContactsLink().click();

		//Navigate Contact Page 
		Contacts cp=new Contacts(driver);
		cp.getContactBtn().click();

		//Navigate Create Contact Page
		CreateNewContacts cnc=new CreateNewContacts(driver);
		cnc.createContact(lastName);

		//Verify The Details
		ContactInformation cinfo=new ContactInformation(driver);
		String actName = cinfo.getSucessfulMsg().getText();
		Assert.assertTrue(actName.contains(lastName));
		Assert.assertEquals("A", "B");
	}
	/**
	 * This method to create Contacts with Organization Name
	 * @param args
	 * @throws Throwable
	 */
	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		//Read Test Data
		String orgName = eLib.getDataFromExcel("sheet1", 1, 3)+jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();

		//Navigate Home Page
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();

		//Navigate to create org page
		Organizations org=new Organizations(driver);
		org.getCreateOrgBtn().click();

		//Create Organization
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		cno.createOrg(orgName);

		//Wait For Header Element
		OrganizationInfo oi=new OrganizationInfo(driver);
		wLib.waitForElementVisibility(driver, oi.getSucessfulMsg());

		//Navigate Contact Page
		hp.getContactsLink().click();

		//Navigate to Create New Contact Page
		Contacts cp=new Contacts(driver);
		cp.getContactBtn().click();

		//Create New Contact With Org
		CreateNewContacts cncon=new CreateNewContacts(driver);
		cncon.createContact(lastName, orgName);
		

		//Verify The Details
		ContactInformation ci=new ContactInformation(driver);
		String actuName = ci.getOrgNameIcon().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actuName.trim(), orgName);
		soft.assertAll();
	}
}
