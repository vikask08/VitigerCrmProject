package com.crm.comcast.genericutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;
/**
 *  This class contains Generic Methods
 * @author VikasK
 *
 */
public class BaseAnnotationClass {

	//Object Creation for Lib
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver=null;

	/**
	 * This method to use connected with DB
	 */
	@BeforeSuite(groups={"regressionTest","smokeTest"})
	public void configBS() {
		System.out.println("==========Connect to DB==================");
	}


	/**
	 * This method to use Lunch The Browser
	 * @throws Throwable
	 */
	//@Parameters("Browser")
	@BeforeClass(groups={"regressionTest","smokeTest"})
	//public void configBC(String Browser) throws Throwable {
	public void configBC() throws Throwable {
			//Read Common Data
			String Browser=fLib.getPropertyKeyValue("browser");
			String Url=fLib.getPropertyKeyValue("url");

			//Lunch the Browser
			if(Browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else if(Browser.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if(Browser.equalsIgnoreCase("IE")) {
				driver=new InternetExplorerDriver();
			}
			else {
				System.out.println("Invalid Browser Please Try with Valid Browser");
			}

			driver.get(Url);
			sDriver=driver;
			wLib.waitUntilPageLoad(driver);
			driver.manage().window().maximize();
		}

		/**
		 * This method to use Login to The App
		 * @throws Throwable
		 */
		@BeforeMethod(groups={"regressionTest","smokeTest"})
		public void configBM() throws Throwable {
			//Read Common Data
			String UserName=fLib.getPropertyKeyValue("username");
			String PassWord=fLib.getPropertyKeyValue("password");


			//Login to App
			Login lg=new Login(driver);
			lg.loginToApp(UserName, PassWord);

		}
		/**
		 * This method to use LogOut the App
		 */
		@AfterMethod(groups={"regressionTest","smokeTest"})
		public void configAM() {
			//Logout the App
			Home hp= new Home(driver);
			hp.logout();
		}

		/**
		 * This method to use Close the Browser
		 */
		@AfterClass(groups={"regressionTest","smokeTest"})
		public void configAC() {
			System.out.println("=============Close the Browser=======");
			driver.quit();
		}

		/**
		 * This method to use close the connection with DB
		 */
		@AfterSuite(groups={"regressionTest","smokeTest"})
		public void configAS() {
			System.out.println("========================DisConnect DB Connection========================");
		}
	}
