package com.Pages.Clothing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.kapruka.utils.WaitFor;

/**
 * Page Object Model for the Clothing page after clicking on the first product. 
 * This class should contain WebElements and methods specific to the product details after clicking on first product.
 */
public class ClothingFirstProductClickPOM {

	@FindBy (xpath = "//div[@class='blockDelivery imgtags']/h1")
	WebElement productTitle;
	@FindBy (xpath = "//div[@class='price']/span")
	WebElement productPrice;
	@FindBy (xpath = "//button[@id='addtocartbutton']")
	WebElement addToCartBtn;
	
	public String captureProductDescription() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='blockDelivery imgtags']/h1"));
		return productTitle.getText();
	}
	
	public String captureProductPrice() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='price']/span"));
		return productPrice.getText();
	}
	
	public void clickAddToCartBtn() {
		WaitFor.elementToBeClickable(By.xpath("//button[@id='addtocartbutton']"));
		addToCartBtn.click();
	}
	
	
	
	
	
	
}
