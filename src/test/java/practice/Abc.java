package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Abc {

	public static void main(String[] args) throws Throwable 
	{
		//step:1-get the java representation object of the physical file.
		FileInputStream fis=new FileInputStream(".\\data\\commonData.properties");
		
		//step 2:load all the keys using properties class.
		Properties p=new Properties();
		p.load(fis);
		
		//step 3:read the data from file using getproperty ("keys").
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
	
		//getRandom Numbers
		Random r=new Random();
	   	int randomNum = r.nextInt(1000);
	   	
	   	//Read test data from excel file
		FileInputStream fis2=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String orgName = row.getCell(1).getStringCellValue()+randomNum;
		System.out.println(orgName);
		
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else 
		{
			System.out.println("Invalid browser");
		}
		
		//step 1:login
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(un);
        driver.findElement(By.name("user_password")).sendKeys(pw);
        driver.findElement(By.id("submitButton")).click();
        
        //step 2: navigate to Organization module
        driver.findElement(By.linkText("Organizations")).click();
        
        //step 3: click on create new Organization button
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
       
        //step 4: enter all the details and create new organization
        driver.findElement(By.xpath(("(//input[@class='detailedViewTextBox'])[1]"))).sendKeys(orgName);
        driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
       
        //step 5: verify organization name in header of the message
         String actualText = driver.findElement(By.className("dvHeaderText")).getText();
         if(actualText.contains(orgName)) 
         {
        	 System.out.println("organization is sucessfully created and pass");
         }
         else
         {
        	 System.out.println("organization is not created and failed");
         } 
         
         //step 6: logout
        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.close();
	}

}
