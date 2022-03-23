package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganization2 {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		//step:1-get the java representation object of the physical file.
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		//step 2:load all the keys using properties class.
		Properties p=new Properties();
		p.load(fis);
		//step 3:read the data from file using getproprty("keys").
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		WebDriver driver=null;//upcasting
		
		
		Random r=new Random();
	    int ran = r.nextInt(1000);
		FileInputStream fis2=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).getStringCellValue()+ran;
		System.out.println(orgName);
		
		
	    
		
		if(browser.equalsIgnoreCase("firefox"));{
		driver=new FirefoxDriver();
		}
		//step 1:login
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
        driver.findElement(By.name("user_password")).sendKeys(pw);
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(orgName);
        driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
         String actualText = driver.findElement(By.className("dvHeaderText")).getText();
         if(actualText.contains(orgName)) {
        	 System.out.println("organization is sucessfully created and pass");
         }
         else {
        	 System.out.println("organization is not created and failed");
         }
        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.close();
	}

}
