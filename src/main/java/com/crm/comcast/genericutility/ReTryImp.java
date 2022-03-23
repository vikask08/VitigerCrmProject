package com.crm.comcast.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryImp implements IRetryAnalyzer {
	     
	int count=0;
	int retrylimit=3;
	
	public boolean retry(ITestResult result) {
		if(count<retrylimit) {
			count++;
			return true;
		}
		return false;
	}
	
}