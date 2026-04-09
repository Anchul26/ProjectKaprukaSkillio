package com.Kapruka;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.Clothing.ClothingFirstProductClickPOM;
import com.kapruka.pages.ClothingPOM;
import com.kapruka.pages.HomePageDashboard;
import com.sourcePackage.BaseClass;
import com.sourcePackage.Keyword;

public class ClothingMenu extends BaseClass {

	@Test (priority = 1)
	public void verifyClothingMenuLoadsSuccessfully() {
		HomePageDashboard homePage = PageFactory.initElements(Keyword.threadLocal.get(), HomePageDashboard.class);
		homePage.clothingMenuToBeClickable();
		homePage.clickClothingMenu();
		String title = Keyword.threadLocal.get().getTitle();
		Assert.assertEquals(title, "Clothing Store Sri Lanka | Online Fashion & Clothes Shop"); //Assertions links keeps changing hence using title instead of url for validation
	}
	
	@Test (priority = 2)
	public void verifyMenClothingMenuLoadsSuccessfully() {
		HomePageDashboard homePage = PageFactory.initElements(Keyword.threadLocal.get(), HomePageDashboard.class);
		homePage.clothingMenuToBeClickable();
		homePage.clickClothingMenu();
		ClothingPOM clothingMenu = PageFactory.initElements(Keyword.threadLocal.get(), ClothingPOM.class);
		clothingMenu.clickMenClothingBtn();
		String title = Keyword.threadLocal.get().getTitle();
		Assert.assertEquals(title, "Men's Fashion Online - Shirts & More in Sri Lanka");		
	}
	
	@Test (priority = 3)
	public void verifySeeMoreProductsFunctionality() {
		HomePageDashboard homePage = PageFactory.initElements(Keyword.threadLocal.get(), HomePageDashboard.class);
		homePage.clothingMenuToBeClickable();
		homePage.clickClothingMenu();
		ClothingPOM clothingMenu = PageFactory.initElements(Keyword.threadLocal.get(), ClothingPOM.class);
		int initialProductCount = clothingMenu.countOfProductsDisplayedAtStart();
		clothingMenu.scrollDownToViewMoreProductsBtn();
		clothingMenu.clickViewMoreProductsBtn();
		int productCount = clothingMenu.countOfProductsAfterViewMoreClick();
		Assert.assertTrue(productCount > initialProductCount, "Expected more than 30 products to be displayed after clicking 'See More Products', but found: " + productCount);				
	}
	
	@Test (priority = 4)
	public void verifyProductAndPriceAccuracy() {
		HomePageDashboard homePage = PageFactory.initElements(Keyword.threadLocal.get(), HomePageDashboard.class);
		homePage.clothingMenuToBeClickable();
		homePage.clickClothingMenu();
		ClothingPOM clothingMenu = PageFactory.initElements(Keyword.threadLocal.get(), ClothingPOM.class);
		String firstProductDescription = clothingMenu.captureFirstProductDescription();
		String firstProductPrice = clothingMenu.captureFirstProductPrice();
		clothingMenu.clickOnFirstProduct();
		ClothingFirstProductClickPOM clothingFirstProductClick = PageFactory.initElements(Keyword.threadLocal.get(), ClothingFirstProductClickPOM.class);
		String productDescriptionOnClick = clothingFirstProductClick.captureProductDescription();
		String productPriceOnClick = clothingFirstProductClick.captureProductPrice();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(firstProductDescription, productDescriptionOnClick, "Product description mismatch: expected '" + firstProductDescription + "' but found '" + productDescriptionOnClick + "'");
		soft.assertEquals(firstProductPrice, productPriceOnClick, "Product price mismatch: expected '" + firstProductPrice + "' but found '" + productPriceOnClick + "'");
		soft.assertAll();		
		
	}
	
	
	
	
}
