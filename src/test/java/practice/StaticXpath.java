package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticXpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//step1: navigate to fipkart4rrrrrrrr v
		driver.get("https://www.tripodeal.com/");
		//enter departure date
		driver.findElement(By.id("origin")).sendKeys("BLR");
		//select BLR in suggestion
		driver.findElement(By.id("eac-container-origin")).click();
		//enter destination
		driver.findElement(By.id("destination")).sendKeys("DEL");
		//select the destination
		driver.findElement(By.linkText("//div[@class='eac-item']/b[text()='DEL']")).click();
		//select date feb 16 2022
		driver.findElement(By.id("dateNew")).click();
		driver.findElement(By.xpath("//div[text()='February']"
				+ "/following-sibling::div[text()='2022']"
				+ "/ancestor::div[@class='picker__box']"
				+ "/descendant::div[text()='16']")).click();

	}

}
