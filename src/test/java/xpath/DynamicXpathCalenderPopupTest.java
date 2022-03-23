package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicXpathCalenderPopupTest {
	@Test
	public void calender() {
		int day = 2;
		String monthAndYear = "March 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
	}

}
