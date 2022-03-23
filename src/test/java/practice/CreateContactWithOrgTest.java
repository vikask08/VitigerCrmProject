package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositorylib.ContactInformation;
import com.crm.comcast.objectrepositorylib.Contacts;
import com.crm.comcast.objectrepositorylib.CreateNewContacts;
import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;
import com.crm.comcast.objectrepositorylib.OrganizationInfo;
import com.crm.comcast.objectrepositorylib.Organizations;
/**
 * This Class Contains 
 * @author VikasK
 *
 */
public class CreateContactWithOrgTest {
	/**
	 * 
	 * @param args
	 * @throws Throwable
	 */
	@Test
	public void createContactWithOrgTest() throws Throwable {
		//Object Creation for Lib
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		//Read Common Data
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");

		//Read Test Data
		String orgName = eLib.getDataFromExcel("sheet1", 1, 3)+jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();

		//Lunch The Browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);

		//Login to App
		Login lg=new Login(driver);
		lg.loginToApp(USERNAME, PASSWORD);
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
		if(actuName.trim().equals(orgName)) {
			System.out.println("Contact is successfully created with Org====PASS");
		}
		else {
			System.out.println("Contact is not created with Org====FAIL");
		}
		
		//LogOut The App
		hp.logout();
		
		//Close The Browser
		driver.close();
	}
}
