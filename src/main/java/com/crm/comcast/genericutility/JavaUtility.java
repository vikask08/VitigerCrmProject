package com.crm.comcast.genericutility;

import java.util.Date;
import java.util.Random;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * This is Generic class which contains generic methods specific to java
 * @author vikas k
 *
 */
public class JavaUtility {
	/**
	 *This is generic method to create random number.its used to generate the integer RanDom number with in the boundary of 0 to 1000
	 * @return
	 */
	public int getRandomNumber() {
		Random ran =new Random();
		int r=ran.nextInt(1000);
		return r;
	}
	/**
	 * This is generic method to get current system date format
	 * @return
	 */
	public String getCurrentDate() {
		Date date=new Date();
		String currentDate = date.toString();
		return currentDate;
	}
	/**
	 * This is generic method for specific date format
	 * @return
	 */
	public String getFinalDateFormat() {
		Date date=new Date();
		String d = date.toString();
		String[] dt = d.split(" ");
		String YYYY = dt[5];
		String MM = dt[1];
		String DD = dt[2];
		String format = DD+"-"+MM+"-"+YYYY;
		return format;
	}
	public void pressVirtualKey() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
