package com.crm.comcast.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.OrganizationInfo;
import com.crm.comcast.objectrepositorylib.Organizations;
/**
 * This class contains testNG specific methods for OrganizationTest
 * @author VikasK
 *
 */
public class OrganizationTest extends BaseAnnotationClass{
	/**
	 * This Methods to create Organization
	 * @param args
	 * @throws Throwable
	 */
	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable {

		int randomInt = jLib.getRandomNumber();

		//Read Test Data
		String orgName = eLib.getDataFromExcel("sheet1", 1, 3)+"_"+randomInt;

		//Navigate to org
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();

		//Navigate to create org page
		Organizations org=new Organizations(driver);
		org.getCreateOrgBtn().click();

		//Create New Organization
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		cno.createOrg(orgName);

		//Verify the Details
		OrganizationInfo orginfo=new OrganizationInfo(driver);
		wLib.waitForElementVisibility(driver,orginfo.getSucessfulMsg() );
		String actSucMsg = orginfo.getSucessfulMsg().getText();
		Assert.assertTrue(actSucMsg.contains(orgName));
		
	}
	/**
	 * This method to create Organization with Industry Type in Given Test Script
	 * @throws Throwable
	 */
	
	@Test(groups="regressionTest")
	public void createOrgWithIndustriesTypeTest() throws Throwable {
		
		//Read Excel Data
		String orgName=eLib.getDataFromExcel("sheet1", 1, 2)+"_"+jLib.getRandomNumber();
		String industry=eLib.getDataFromExcel("sheet1", 2, 6);

		//Navigate to org
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();

		//Navigate to create org page
		Organizations org=new Organizations(driver);
		org.getCreateOrgBtn().click();

		//Create New Organization
		CreateNewOrganization cnorg=new CreateNewOrganization(driver);
		cnorg.createOrg(orgName,industry);

		//Verify the Details
		OrganizationInfo orginf=new OrganizationInfo(driver);
		String actOrgMsg = orginf.getSucessfulMsg().getText();
		Assert.assertTrue(actOrgMsg.contains(orgName));
		String actualOrgInfo=orginf.getIndustrySucessMsg().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualOrgInfo, industry);
		soft.assertAll();
	}
}
