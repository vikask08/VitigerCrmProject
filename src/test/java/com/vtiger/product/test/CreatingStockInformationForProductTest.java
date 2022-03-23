package com.vtiger.product.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreatingStockInformationForProductTest {

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
		driver.findElement(By.name("productname")).sendKeys("Monitor");
		driver.findElement(By.name("assigntype")).click();
		
		
		WebElement drag = driver.findElement(By.name("usageunit"));
		Select s=new Select(drag);
		s.selectByIndex(8);
		
		driver.findElement(By.name("qtyinstock")).sendKeys("23");
		driver.findElement(By.name("qty_per_unit")).sendKeys("12");
		driver.findElement(By.id("reorderlevel")).sendKeys("13544");
		driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
		
		
		WebElement drag2 = driver.findElement(By.name("assigned_group_id"));
		Select s2=new Select(drag2);
		s2.selectByIndex(2);
		
		
		driver.findElement(By.id("qtyindemand")).sendKeys("12");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		System.out.println("Details are Accepted------->Pass");
		
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Login Page displayed------>Pass");
		driver.close();
	}

}
