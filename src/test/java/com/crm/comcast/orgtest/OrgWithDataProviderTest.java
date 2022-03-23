package com.crm.comcast.orgtest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.OrganizationInfo;
import com.crm.comcast.objectrepositorylib.Organizations;
/**
 * 
 * @author VikasK
 *
 */
public class OrgWithDataProviderTest extends BaseAnnotationClass{
	/**
	 * 
	 * @param orgName
	 * @param indType
	 */
	@Test(dataProvider="dataProvider_industryType")
	public void orgWithDataProvider(String orgName,String indType) {
		
				//Navigate to org
				Home hp=new Home(driver);
				hp.getOrganizationLink().click();

				//Navigate to create org page
				Organizations org=new Organizations(driver);
				org.getCreateOrgBtn().click();

				//Create New Organization
				CreateNewOrganization cnorg=new CreateNewOrganization(driver);
				cnorg.createOrg(orgName,indType);

				//Verify the Details
				OrganizationInfo orginf=new OrganizationInfo(driver);
				String actOrgMsg = orginf.getSucessfulMsg().getText();
				Assert.assertTrue(actOrgMsg.contains(orgName));
				String actualOrgInfo=orginf.getIndustrySucessMsg().getText();
				
	}
      /**
       * This method to use read data from data provider
       * @return
       * @throws Throwable
       * @throws Throwable
       */
	@DataProvider
	public Object[][] dataProvider_industryType() throws Throwable, Throwable{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("industryType");
		
		Object[][] objAry=new Object[rowCount][2];

		for(int i=1;i<rowCount-1;i++) {
			
			objAry[i][0]=eLib.getDataFromExcel("industryType", i, 0)+jLib.getRandomNumber();
			objAry[i][1]=eLib.getDataFromExcel("industryType", i, 1);
			
		}
		return objAry;
	}
}
