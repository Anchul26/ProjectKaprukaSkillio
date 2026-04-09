package com.kapruka.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kapruka.utils.WaitFor;
import com.sourcePackage.Keyword;

/**
 * Page Object Model for the Clothing page. This class should contain WebElements and methods specific to the Clothing page.
 * Web address of this page is https://www.kapruka.com/clothing or https://www.kapruka.com/online/clothing (url seems to be changing hence added both the urls here)
 */

public class ClothingPOM {
	
	@FindBy( xpath = "//a[@title='Shop For All Items']")
	WebElement allItemsBtn;	
	@FindBy (xpath = "//a[@title='Shop For Womens Clothing b(699)b']")
	WebElement womenClothingBtn;
	@FindBy (xpath = "//a[@title='Shop For Mens Clothing b(419)b']//span[1]")
	WebElement menClothingBtn;
	@FindBy (xpath = "//a[@title='Shop For Saree b(284)b']")
	WebElement sariClothingBtn;
	@FindBy (xpath = "//a[@title='Shop For Kids Clothing b(88)b']")
	WebElement kidsClothingBtn;
	@FindBy (xpath ="//a[@title='Shop For Unisex Clothing b(41)b']")
	WebElement unisexClothingBtn;
	@FindBy (xpath ="//a[@title='Shop For Clothing Gift Sets b(10)b']")
	WebElement clothingGiftSetBtn;
	@FindBy (xpath = "Shop For Saree Blouse")
	WebElement sareeBlouseBtn;
	@FindBy (xpath = "//a[@title='Shop For Mens Activewear']")
	WebElement mensActiveWearBtn;
	@FindBy (xpath = "//a[@title='Shop For Women Activewear']")
	WebElement womenActiveWearBtn;
	@FindBy(xpath = "//a[@title='Shop For Skirt']")
	WebElement skirtBtn;
	@FindBy (xpath = "//a[@title='Shop For Maternity Wear']")
	WebElement materityWearBtn;
	@FindBy (xpath = "//a[@id='viewMoreButton']")
	WebElement viewMoreProductsBtn;
	@FindBy(xpath = "(//div[@class='catalogueV2textBlock'])[1]/div[1]")
	WebElement firstProductDescription;
	@FindBy(xpath = "(//div[@class='catalogueV2textBlock'])[1]/div[2]")
	WebElement firstProductPrice;
	
	
		
	public void clickAllItemsBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For All Items']"));
		allItemsBtn.click();
	}
	
	public void clickWomenClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Womens Clothing b(699)b']"));
		womenClothingBtn.click();
	}
	
	public void clickMenClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Mens Clothing b(419)b']//span[1]"));
		menClothingBtn.click();
	}
	
	public void clickSariClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Saree b(284)b']"));
		sariClothingBtn.click();
	}
	
	public void clickKidsClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Kids Clothing b(88)b']"));
		kidsClothingBtn.click();
	}
	
	public void clickUnisexClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Unisex Clothing b(41)b']"));
		unisexClothingBtn.click();
	}
	
	public void clickClothingGiftSetBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Clothing Gift Sets b(10)b']"));
		clothingGiftSetBtn.click();
	}
	
	public void clickSareeBlouseBtn() {
		WaitFor.elementToBeClickable(By.xpath("Shop For Saree Blouse"));
		sareeBlouseBtn.click();
	}
	
	public void clickMensActiveWearBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Mens Activewear']"));
		mensActiveWearBtn.click();
	}
	
	public void clickWomenActiveWearBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Women Activewear']"));
		womenActiveWearBtn.click();
	}
	
	public void clickSkirtBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Skirt']"));
		skirtBtn.click();
	}
	
	
	public void clickMaterityWearBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Maternity Wear']"));
		materityWearBtn.click();
	}
	
	
	public void clickViewMoreProductsBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@id='viewMoreButton']"));
		viewMoreProductsBtn.click();
	}
	
	public int countOfProductsAfterViewMoreClick() {
		List<WebElement> productsDisplayedAtStart = Keyword.threadLocal.get().findElements(By.xpath("//div[@class = 'catalogueV2Repeater ']/a"));
		int initialProductCount = productsDisplayedAtStart.size();
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[@class = 'catalogueV2Repeater ']"), initialProductCount);
		List<WebElement> productsDisplayed = Keyword.threadLocal.get().findElements(By.xpath("//div[@class = 'catalogueV2Repeater ']"));
		int productCount = productsDisplayed.size();
		return productCount;		
	}
	
	public int countOfProductsDisplayedAtStart() {
		List<WebElement> productsDisplayedAtStart = Keyword.threadLocal.get().findElements(By.xpath("//div[@class = 'catalogueV2Repeater ']/a"));
		int initialProductCount = productsDisplayedAtStart.size();
		return initialProductCount;		
	}
	
	public void clickOnFirstProduct() {
		List<WebElement> productsDisplayedAtStart = Keyword.threadLocal.get().findElements(By.xpath("//div[@class = 'catalogueV2Repeater ']"));
		//int initialProductCount = productsDisplayedAtStart.size();
		//WaitFor.elementToBeClickable(By.xpath("(//div[@class = 'catalogueV2Repeater '])[1]"));
		productsDisplayedAtStart.get(0).click();				
	}
	
	public String captureFirstProductDescription() {
		WaitFor.elementToBeVisible(By.xpath("(//div[@class='catalogueV2textBlock'])[1]/div[1]"));
		return firstProductDescription.getText();
	}
	
	public String captureFirstProductPrice() {
		WaitFor.elementToBeVisible(By.xpath("(//div[@class='catalogueV2textBlock'])[1]/div[2]"));
		return firstProductPrice.getText();
	}
	

	public void scrollDownToViewMoreProductsBtn() {
		JavascriptExecutor js = (JavascriptExecutor) Keyword.threadLocal.get();
		js.executeScript("window.scrollBy(0, -100);");
		//Keyword.threadLocal.get().executeScript("arguments[0].scrollIntoView(true);", viewMoreProductsBtn);		
	}
	
}
