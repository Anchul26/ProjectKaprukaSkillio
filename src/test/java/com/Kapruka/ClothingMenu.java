package com.Kapruka;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kapruka.pages.HomePageDashboard;
import com.sourcePackage.BaseClass;
import com.sourcePackage.Keyword;

public class ClothingMenu extends BaseClass {

	@Test (priority = 1)
	public void clothingMenu() {
		HomePageDashboard homePage = PageFactory.initElements(Keyword.threadLocal.get(), HomePageDashboard.class);
		homePage.clothingMenuToBeClickable();
		homePage.clickClothingMenu();
		Assert.assertEquals(Keyword.threadLocal.get().getCurrentUrl(), "https://www.kapruka.com/online/clothing");
	}
}
