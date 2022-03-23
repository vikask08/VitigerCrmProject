package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
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
				
				if(browser.equalsIgnoreCase("firefoxdriver")){
				driver=new FirefoxDriver();
				}
				//step 1:login
				driver.get(url);
				driver.findElement(By.name("user_name")).sendKeys(un);
		        driver.findElement(By.name("user_password")).sendKeys(pw);
		        driver.findElement(By.id("submitButton")).click();

	}

}
