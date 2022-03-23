package practice;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DesiredCapability {
	@Test
	public void desiredTest()
	 {
		String URL = "http://localhost:8888";
		DesiredCapabilities d=new DesiredCapabilities();
		d.firefox();
		d.setBrowserName("firefox");
		d.setPlatform(Platform.WINDOWS);
		d.setVersion("97.0");
		d.getPlatform();
		
	 }
}
