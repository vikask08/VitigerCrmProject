package xpath;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AnyMonthTest {
	@Test
	public void calender() {
		LocalDateTime systemdate=LocalDateTime.now().plusMonths(6);
		int date = systemdate.getDayOfMonth();
		String month = systemdate.getMonth().toString();
		String actualmonth = month.substring(0, 1)+month.substring(1).toLowerCase();
		System.out.println(actualmonth);
		int year = systemdate.getYear();
		String monthAndYear = actualmonth+" "+year;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		
	
		}
	}

}
