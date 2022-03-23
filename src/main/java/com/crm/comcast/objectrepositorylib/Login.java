package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver,this);//at the place of this we can write Login.class	
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement suserPassEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getSuserPassEdt() {
		return suserPassEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void loginToApp(String username, String password) {
		userNameEdt.sendKeys(username);
		suserPassEdt.sendKeys(password);
		loginBtn.click();
	}
}
