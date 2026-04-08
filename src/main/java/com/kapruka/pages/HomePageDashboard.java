package com.kapruka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kapruka.utils.WaitFor;

public class HomePageDashboard {

	@FindBy(xpath = "//div[@class=' hambuger_menu text menu-icon']")
	WebElement allCategoriesBtn;
	@FindBy(xpath = "//li[@class='active_event']")
	WebElement activeEventsBtn;
	@FindBy(xpath = "//span[@class='active-fes-svg']")
	WebElement rushDeliveryBtn;
	@FindBy(xpath ="//img[@alt='Clothing Image']")
	WebElement clothingMenu;
	
	public void clothingMenuToBeClickable() {
		WaitFor.elementToBeClickable(By.xpath("//img[@alt='Clothing Image']"));
	}
	
	public void clickClothingMenu() {
		clothingMenu.click();
	}

}
