package practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CustomWait {

	@Test
	public void waitForElementTest(WebElement element) throws Throwable {
		int count =0;
		while(count<=20) {
			try {
				element.isDisplayed();
			} catch (Exception e) {
				Thread.sleep(2000);
				count++;
			}
		}
	}

}
