package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VKA {
	@Test
	public void getSal() throws Throwable {
		WebDriverManager.chromedriver(). setup ();
		ChromeOptions options=new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);		 
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		
		 WebElement sal = driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]"));
		 
		System.out.println(sal.getText());

	}
}
