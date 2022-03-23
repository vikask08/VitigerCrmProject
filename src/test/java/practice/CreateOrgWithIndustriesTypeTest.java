package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;
import com.crm.comcast.objectrepositorylib.OrganizationInfo;
import com.crm.comcast.objectrepositorylib.Organizations;

public class CreateOrgWithIndustriesTypeTest {
	
	@Test
	public void createOrgWithIndustriesTypeTest() throws Throwable {
		
    //Object Creation for Lib
	FileUtility fLib=new FileUtility();
    JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	//Read Common Data
	String Browser=fLib.getPropertyKeyValue("browser");
	String Url=fLib.getPropertyKeyValue("url");
	String UserName=fLib.getPropertyKeyValue("username");
	String PassWord=fLib.getPropertyKeyValue("password");
	
	//Read Excel Data
	String orgName=eLib.getDataFromExcel("sheet1", 1, 2)+"_"+jLib.getRandomNumber();
	String industry=eLib.getDataFromExcel("sheet1", 2, 6);
	
	//Lunch the Browser
	WebDriver driver=null;
	if(Browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else if(Browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else {
		System.out.println("Invalid Browser Please Try with Valid Browser");
	}
	//Login to App
	driver.get(Url);
	wLib.waitUntilPageLoad(driver);
	Login lg=new Login(driver);
	lg.loginToApp(UserName, PassWord);
	
	//Navigate to org
	Home hp=new Home(driver);
	hp.getOrganizationLink().click();
	
	//Navigate to create org page
	Organizations org=new Organizations(driver);
	org.getCreateOrgBtn().click();
	
	//Create New Organization
	CreateNewOrganization cnorg=new CreateNewOrganization(driver);
	cnorg.createOrg(orgName);
	//Verify the Details
	OrganizationInfo orginf=new OrganizationInfo(driver);
	String actOrgMsg = orginf.getSucessfulMsg().getText();
	if(actOrgMsg.contains(orgName)) {
		System.out.println("Org Created Sucessfully====PASS");
	}else {
		System.out.println("Org not Created Sucessfully====FAIL");
	}
	String actualOrgInfo=orginf.getIndustrySucessMsg().getText();
	if(actualOrgInfo.trim().equals(industry)) {
		System.out.println("Org is Sucessfully Created With Industry====PASS");
	}
	else {
		System.out.println("Org is not Created With Industry====FAIL");
	}
	//Close the browser
	hp.logout();
	//Close the Browser
	driver.quit();		
	}
}
