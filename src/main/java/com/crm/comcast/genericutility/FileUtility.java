package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author 
 * vikasK
 *
 */
public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
