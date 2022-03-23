package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.Home;


//@Listeners(com.crm.comcast.genericutility.LisImpClass.class)
public class Sample_ScreenShot extends BaseAnnotationClass{
	
	@Test
	public void ContactsTest() {
		
		Home hp=new Home(driver);
		hp.getContactsLink().click();
		 Assert.assertEquals("A", "B");
	}

}
