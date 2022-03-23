package com.vtiger.product.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {

		//Object Creation for Lib
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		int randomInt = jLib.getRandomNumber();

		//common Data
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");

		//test script Data
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;

		WebDriver driver=null;

		if(BROWSER.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		//step 1:login
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//step 2 : navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(orgName);
		WebElement dd = driver.findElement(By.name("industry"));
		String option = "Education";
		wLib.select(dd, option);
		WebElement in = driver.findElement(By.name("accounttype"));
		wLib.select(in, 2);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		String actualText = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualText.contains(orgName)) {
			System.out.println("organization is sucessfully created and pass");
		}
		else {
			System.out.println("organization is not created and failed");
		}
		//step 3:switch window
		WebElement sw = driver.findElement(By.linkText("Contacts"));
		sw.click();
		String act = sw.getText();
		wLib.switchToWindow(driver, act);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("account_name")).sendKeys(orgName);
		driver.findElement(By.xpath("//img[@language='javascript']")).click();
		WebElement send = driver.findElement(By.id("search_txt"));
        send.sendKeys("vtiger");
        jLib.pressVirtualKey();
		//step  : logout
		  WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	      wLib.mouseOver(driver, move);
	      driver.findElement(By.linkText("Sign Out")).click();
	      System.out.println("logout sucessfully and display login page");
	      driver.close();
	}
}
