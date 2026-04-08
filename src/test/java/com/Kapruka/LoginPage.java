package com.Kapruka;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kapruka.pages.LoginPagePOM;
import com.kapruka.utils.App;
import com.sourcePackage.BaseClass;
import com.sourcePackage.Keyword;

public class LoginPage extends BaseClass {


	
	@Test (priority = 0)
	public void loginUsingPOM() {
		LoginPagePOM loginPagePOM = PageFactory.initElements(Keyword.threadLocal.get(), LoginPagePOM.class);
		loginPagePOM.loginAccountbtnToBeClickable();
		loginPagePOM.clickLoginAccountBtn();
		loginPagePOM.userNameToBeVisible();
		loginPagePOM.enterUserName(App.getUserName("qa"));
		loginPagePOM.enterPassword(App.getPassword("qa"));
		loginPagePOM.clickLoginBtn();
		String title = Keyword.threadLocal.get().getTitle();
		System.out.println("title:"+title);
		Assert.assertEquals(title, "Your Account"); //Assertions links keeps changing hence using title instead of url for validation
				
	}
	
	@Test (priority = 1)
	public void logingUsingInvalidPassword() {
		LoginPagePOM loginPagePOM = PageFactory.initElements(Keyword.threadLocal.get(), LoginPagePOM.class);
		loginPagePOM.loginAccountbtnToBeClickable();
		loginPagePOM.clickLoginAccountBtn();
		loginPagePOM.userNameToBeVisible();
		loginPagePOM.enterUserName(App.getUserName("qa"));
		loginPagePOM.enterPassword("Password123");
		loginPagePOM.clickLoginBtn();
		loginPagePOM.errorMsgToBeVisible();
		String errorMessage = loginPagePOM.getErrorMsg();
		Assert.assertEquals(errorMessage, "Your password is wrong. Please try again.");		
	}
	
	@Test (priority = 2)
	public void logingUsingInvalidEmail() {
		LoginPagePOM loginPagePOM = PageFactory.initElements(Keyword.threadLocal.get(), LoginPagePOM.class);
		loginPagePOM.loginAccountbtnToBeClickable();
		loginPagePOM.clickLoginAccountBtn();
		loginPagePOM.userNameToBeVisible();
		loginPagePOM.enterUserName("achul@gmail.com");
		loginPagePOM.enterPassword(App.getPassword("qa"));
		loginPagePOM.clickLoginBtn();
		loginPagePOM.errorMsgToBeVisible();
		String errorMessage = loginPagePOM.getErrorMsg();
		Assert.assertEquals(errorMessage, "Sorry, we did not find an account for that e-mail address.");		
	}
	
}
