package com.vtiger.product.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatingDescriptionInformationForProductTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commondata.properties");

		Properties p=new Properties();
		p.load(fis);

		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		WebDriver driver=null;

		if(browser.equalsIgnoreCase("firefox")){


			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("Nokia");
		driver.findElement(By.name("description")).sendKeys("For a decade beginning in 1998, Nokia was the largest worldwide vendor of mobile phones and smartphones. ... The Nokia brand returned to the mobile and smartphone market in 2016 through a licensing arrangement with HMD Global. Nokia continues to be a major patent licensor for most large mobile phone vendors.");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Login Page displayed------>Pass");
         driver.close();
	}

}
