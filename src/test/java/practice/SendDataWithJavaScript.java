package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SendDataWithJavaScript {
	@Test
	public void sendData() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		WebElement move = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		Actions action=new Actions(driver);
		action.moveToElement(move).perform();
		driver.findElement(By.xpath("//span[.='Sign in']")).click();
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeAsyncScript("document.getElementById('ap_email').value='zvikas.82'");
		j.executeAsyncScript("document.getElementById('ap_email').value='zvikas.82'");
			
	
	}

}
