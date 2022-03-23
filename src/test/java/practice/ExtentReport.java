package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.Home;


public class ExtentReport extends BaseAnnotationClass {

	
	@Test
	public void extent() {
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		Assert.assertEquals("a", "b");
	}
}
