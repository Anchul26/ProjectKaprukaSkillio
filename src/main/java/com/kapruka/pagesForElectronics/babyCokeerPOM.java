package com.kapruka.pagesForElectronics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sourcePackage.Keyword;

public class babyCokeerPOM
{
	
@FindBy(xpath="//img[@title=\"Buy singer Panasonic in Sri Lanka\"]")
WebElement clickOnCooker;

@FindBy(xpath="//span[@id=\"pricelbl\"]") WebElement GetPrice;

{
	PageFactory.initElements(Keyword.threadLocal.get(), this);
}




public void clickOnCookerr() {
	clickOnCooker.click();

}
public String displayedPrice() {
	return GetPrice.getText();

}
}
