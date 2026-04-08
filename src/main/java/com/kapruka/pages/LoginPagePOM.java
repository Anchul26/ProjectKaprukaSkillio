package com.kapruka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kapruka.utils.WaitFor;

public class LoginPagePOM {

	@FindBy(xpath ="//a[@aria-label='Login to Your Account']//*[name()='svg']")
	WebElement loginAccountbtn;
	
	@FindBy(xpath = "//input[@id='exampleInputEmail1']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	WebElement password;
	 
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath ="(//font[@color='red'])[1]")
	WebElement errorMsg;
	
	public void clickLoginAccountBtn() {
		loginAccountbtn.click();
	}
	
	public void enterUserName(String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clearUserName() {
		userName.clear();
	}
	
	public void clearPassword() {
		password.clear();
	}
	
	public void loginAccountbtnToBeClickable() {
		WaitFor.elementToBeClickable(By.xpath("//a[@aria-label='Login to Your Account']//*[name()='svg']"));
		
	}
	
	public String getErrorMsg() {
		return errorMsg.getText();
	}
	
	public void errorMsgToBeVisible() {
		WaitFor.elementToBeVisible(By.xpath("(//font[@color='red'])[1]"));
	}
	
	public void userNameToBeVisible() {
		WaitFor.elementToBeVisible(By.xpath("//input[@id='exampleInputEmail1']"));
	}
	
	
}
