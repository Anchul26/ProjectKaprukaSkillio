package com.kapruka.pagesForElectronics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sourcePackage.Keyword;

public class ElectronicsPOM {
	
	@FindBy(xpath= "//img[@src=\"/static/image/menu_categories/elec.png?v2\"]")
	WebElement ElectronicsClick;
	
	@FindBy(xpath= "//img[@title=\"Buy Innovex Innovex in Sri Lanka\"]") WebElement clickonMixture;
	
	@FindBy(xpath="//button[@id=\"addtocartbutton\"]") WebElement clickOnAddtoCartButton;
	
	@FindBy(xpath="//a[text()=\"View Cart\"]") WebElement clickOnViewButton;
	
	@FindBy(xpath="//img[@style=\"max-width: 14px\"]") WebElement deleteproduct;
	
	@FindBy(xpath="//div[text()=\"Product Removed From Cart\"]") WebElement deleteMsg;
	
	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}
	
	public void clickOnElectronics() {
		
		ElectronicsClick.click();
		
	}
	public void mixtureclick() {
		clickonMixture.click();
		Actions action=new Actions(Keyword.threadLocal.get());
		action.scrollByAmount(0, 200);


	}
	public void clickonaddtocart() {
		clickOnAddtoCartButton.click();		

	}
	public void clickonview() {
		clickOnViewButton.click();

	}
	public void deletetheproduct() {
		deleteproduct.click();
		

	}
	public String getMsg() {
		 return deleteMsg.getText();
		
		
	}
	public void verfjg() {
		// TODO Auto-generated method stub

	}
	
}
//this is important fan